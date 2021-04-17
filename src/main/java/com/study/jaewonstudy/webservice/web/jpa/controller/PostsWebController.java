package com.study.jaewonstudy.webservice.web.jpa.controller;

import com.study.jaewonstudy.webservice.web.jpa.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/spring")
public class PostsWebController {

    private PostsService postsService;

    @GetMapping("/post")
    public String postMain(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "spring/posts/main";
    }

}
