package com.study.jaewonstudy.webservice.web.spring.service;

import com.study.jaewonstudy.webservice.web.spring.model.request.Member;

public interface MemberService {

	Member login(String loginId, String loginPw);
}
