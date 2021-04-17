package com.study.jaewonstudy.webservice.web.jpa.controller;

import com.study.jaewonstudy.webservice.web.jpa.domain.posts.PostsRepository;
import com.study.jaewonstudy.webservice.web.jpa.dto.posts.PostsSaveRequestDto;
import com.study.jaewonstudy.webservice.web.jpa.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/spring")
public class PostsRestController {

    private PostsRepository postsRepository;

    private PostsService postsService;

    @PostMapping("/post/save")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
