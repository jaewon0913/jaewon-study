package com.study.jaewonstudy.webservice.web.spring.service;

import com.study.jaewonstudy.webservice.web.spring.model.request.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="memberService")
public class MemberServiceImpl implements MemberService {
	
	private List<Member> members = new ArrayList<>();
	{
		members.add(new Member("testId@test.com", "test1234", "Jack", "male", 32, "Programmer", "N"));
		members.add(new Member("adminId@admin.com", "admin1234", "Scarlett", "female", 28, "Movie Actor", "N"));
		members.add(new Member("userId@user.com", "user1234", "Hanson", "male", 22, "College Student", "N"));
	}

	@Override
	public Member login(String loginId, String loginPw) {
		
		Member selectMember = members.stream()
				.filter(m -> m.getMemberId().equals(loginId) && m.getMemberPw().contentEquals(loginPw))
				.findFirst().orElse(null);
		
		return selectMember;
	}

}
