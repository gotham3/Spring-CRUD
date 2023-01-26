package com.learn.springmongo.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class SwaggerConfig implements WebMvcConfigurer {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        //        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.learn.springmongo.controller"))
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .paths(regex("/api/todo/.*"))
        .build();
  }
}
