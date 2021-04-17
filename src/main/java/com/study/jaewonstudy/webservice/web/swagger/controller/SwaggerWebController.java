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
    	
    	return "spring/swagger/swagger";
    }
}
