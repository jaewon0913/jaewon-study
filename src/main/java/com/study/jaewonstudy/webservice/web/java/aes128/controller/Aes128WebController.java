package com.study.jaewonstudy.webservice.web.java.aes128.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/java")
public class Aes128WebController {

    @GetMapping("/aes")
    public String aesTest() {
    	
    	return "java/aes128/aesTest";
    }
}
