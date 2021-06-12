package com.study.jaewonstudy.webservice.web.spring.share.controller;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@NoArgsConstructor
@RequestMapping("/spring")
public class ShareWebController {

    @GetMapping("/share")
    public String index(HttpServletRequest request, Model model){

        String myUrl = request.getRequestURL().toString();

        model.addAttribute("myUrl", myUrl);

        return "spring/share/share";
    }
}
