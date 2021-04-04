package com.study.jaewonstudy.webservice.web.spring.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	
	private String memberId;
	private String memberPw;
	private String name;
	private String gender;
	private int age;
	private String job;
	private String status;
	
	public Member() {}
	
	@java.beans.ConstructorProperties({"memberId", "memberPw", "name", "gender", "age", "job", "status"})
	public Member(String memberId, String memberPw, String name, String gender, int age, String job, String status) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.job = job;
		this.status = status;
	}
}
