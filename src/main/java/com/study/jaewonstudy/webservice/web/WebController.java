package com.study.jaewonstudy.webservice.web;

import com.study.jaewonstudy.webservice.web.jpa.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String index(){

        return "index";
    }

}
