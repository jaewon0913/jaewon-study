package com.study.jaewonstudy.webservice.web.swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/spring")
public class SwaggerWebController {

    @GetMapping("/swagger")
    public String swagger() {
    	
    	//return "/spring/swagger/swagger";     <-- 리눅스에서 파일위치를 찾지 못함
    	return "spring/swagger/swagger";
    }
}
