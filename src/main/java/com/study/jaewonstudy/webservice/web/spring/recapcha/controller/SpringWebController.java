package com.study.jaewonstudy.webservice.web.spring.recapcha.controller;

import com.study.jaewonstudy.webservice.web.spring.recapcha.model.request.Member;
import com.study.jaewonstudy.webservice.web.spring.recapcha.service.MemberService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@NoArgsConstructor
@RequestMapping("/spring")
public class SpringWebController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/recaptcha")
    public String recaptcha(){

        return "spring/recaptcha/recaptcha";
    }

    @GetMapping("/recaptcha/after")
    public String recaptchaAfter(@RequestParam String memberId, @RequestParam String memberPw, Model model){

        Member loginMember = memberService.login(memberId, memberPw);

        model.addAttribute("member", loginMember);

        return "spring/recaptcha/afterRecaptcha";
    }
}
