package com.study.jaewonstudy.webservice.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private String version;
    private String title;
    
    @Bean
    public Docket apiV1() {
        version = "V1";
        title = "Board API " + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.study.jaewonstudy.webservice.web.swagger.controller"))
                .paths(PathSelectors.ant("/spring/swagger/v1/api/**"))
                .build()
                .apiInfo(apiInfo(title, version))
                .globalResponseMessage(RequestMethod.GET, responseMessages());

    }

    @Bean
    public Docket apiV2() {
        version = "V2";
        title = "Board API " + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.study.jaewonstudy.webservice.web.swagger.controller"))
                .paths(PathSelectors.ant("/spring/swagger/v2/api/**"))
                .build()
                .apiInfo(apiInfo(title, version));

    }

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title,
                "Swagger Example API Docs",
                version,
                "www.jaewon-study.com",
                new Contact("Contact Me", "www.jaewon-study.com", "jaewon9937@gmail.com"),
                "Licenses",

                "www.jaewon-study.com",

                new ArrayList<>());
    }
    
    private List<ResponseMessage> responseMessages() {
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder()
                .code(200)
                .message("OK!!!!! ~~")
                .build());
        responseMessages.add(new ResponseMessageBuilder()
                .code(404)
                .message("Not Found ~~")
                .build());
        responseMessages.add(new ResponseMessageBuilder()
                .code(500)
                .message("Internal Server Error ~~")
                .build());
        
        return responseMessages;
    }
}
