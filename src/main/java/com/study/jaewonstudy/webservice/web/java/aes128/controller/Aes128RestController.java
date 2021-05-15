package com.study.jaewonstudy.webservice.web.java.aes128.controller;

import com.study.jaewonstudy.webservice.config.AES128Config;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;

@RestController
@RequestMapping("/java")
public class Aes128RestController {

    private final String aesKey = "123456test123456";

    //  암호화
    @GetMapping("/aes/encrypt")
    public String encrypt(@RequestParam String text) throws Exception {

        AES128Config aes128 = new AES128Config(aesKey);
        String encryptText = aes128.encrypt(text);
    	
    	return encryptText;
    }

    //  복호화
    @GetMapping("/aes/decrypt")
    public String decrypt(@RequestParam String text) throws Exception {

        AES128Config aes128 = new AES128Config(aesKey);
        String decryptText = aes128.decrypt(text);

        return decryptText;
    }
}
