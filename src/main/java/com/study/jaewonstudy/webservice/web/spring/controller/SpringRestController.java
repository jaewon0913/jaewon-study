package com.study.jaewonstudy.webservice.web.spring.controller;

import com.study.jaewonstudy.webservice.config.RecaptchaConfig;
import com.study.jaewonstudy.webservice.web.spring.model.request.ReqRecaptchaForm;
import com.study.jaewonstudy.webservice.web.spring.model.request.Member;
import com.study.jaewonstudy.webservice.web.spring.model.response.ResRecaptchaForm;
import com.study.jaewonstudy.webservice.web.spring.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring")
//@PropertySource("file:/home/ec2-user/app/dataSource.properties")
@PropertySource("classpath:dataSource.properties")    //<-- 로컬개발
public class SpringRestController {

    @Autowired
    MemberServiceImpl memberService;

    @Value("${recaptcha.secretKey}")
    private String secretKey;

    @GetMapping("/recaptcha/login")
    public ResRecaptchaForm login(ReqRecaptchaForm form) {

        ResRecaptchaForm resp = new ResRecaptchaForm();

        //  [S]리캡차 검증
        try {
            RecaptchaConfig.setSecretKey(secretKey);
            Boolean verify = RecaptchaConfig.verify(form.getRecaptcha());

            if(!verify){
                resp.setStatus(false);
                resp.setErrMsg("reCAPTCHA 검증 실패");

                return resp;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        //  [E]리캡차 검증

        Member loginMember = memberService.login(form.getMemberId(), form.getMemberPw());

        if(loginMember != null) {
            resp.setMember(loginMember);
            resp.setStatus(true);
        } else {
            resp.setStatus(false);
            resp.setErrMsg("로그인 실패");
        }

        return resp;
    }
}
