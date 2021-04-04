package com.study.jaewonstudy.webservice.web.spring.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqRecaptchaForm {

    private String recaptcha;

    private String memberId;
    private String memberPw;
}
