package com.study.jaewonstudy.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/jaewon/myprofile")
    public String myprofile(){

        return "jaewon/myprofile";
    }

    @GetMapping("/vue")
    public String vue(){

        return "vue/index";
    }
}
