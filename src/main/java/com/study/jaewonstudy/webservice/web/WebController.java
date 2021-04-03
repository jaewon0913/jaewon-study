package com.study.jaewonstudy.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/")
    public String main(){

        return "index";
    }

    @GetMapping("/finish")
    public String finish(){

        return "finish";
    }

}
