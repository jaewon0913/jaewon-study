package com.study.jaewonstudy.webservice.web.spring.model.response;

import com.study.jaewonstudy.webservice.web.spring.model.request.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResRecaptchaForm {

    private boolean status;

    private String errMsg;

    private Member member;
}
