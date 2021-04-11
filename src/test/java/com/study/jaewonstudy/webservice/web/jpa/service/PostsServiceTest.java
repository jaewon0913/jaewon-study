package com.study.jaewonstudy.webservice.web.jpa.service;

import org.hamcrest.MatcherAssert;

import static org.hamcrest.CoreMatchers.equalTo;

import com.study.jaewonstudy.webservice.web.jpa.domain.posts.Posts;
import com.study.jaewonstudy.webservice.web.jpa.domain.posts.PostsRepository;
import com.study.jaewonstudy.webservice.web.jpa.dto.posts.PostsSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다() {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("jojoldu@gmail.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        MatcherAssert.assertThat(posts.getAuthor(), equalTo(dto.getAuthor()));
        MatcherAssert.assertThat(posts.getContent(), equalTo(dto.getContent()));
        MatcherAssert.assertThat(posts.getTitle(), equalTo(dto.getTitle()));
    }
}