package com.study.jaewonstudy.webservice.web.spring.recapcha.service;

import com.study.jaewonstudy.webservice.web.spring.recapcha.model.request.Member;

public interface MemberService {

	Member login(String loginId, String loginPw);
}
