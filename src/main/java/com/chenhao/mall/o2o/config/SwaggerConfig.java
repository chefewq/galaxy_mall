package com.chenhao.mall.o2o.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket docket(Environment environment) {
        Docket docket = new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo())
                .groupName("陈浩")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chenhao.mall.o2o.controller"))
                //.paths(PathSelectors.ant("/chen/**"))
                .build();
        return docket;
    }


    public ApiInfo apiInfo() {
        Contact contact = new Contact("陈浩", "http://www.apache.org/licenses/LICENSE-2.0", "2405676953@qq.com");
        return new ApiInfo("星洋商城SwaggerApi文档",
                "不要停下前进的脚步",
                "v2.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
}
