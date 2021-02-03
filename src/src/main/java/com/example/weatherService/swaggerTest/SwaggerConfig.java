package com.example.weatherService.swaggerTest;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;


/**
 * Created by Nasreen Azam Khan on 01/01/2021
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return regex("/weatherInfo.*");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Weather Service ")
                .description(" A RESTful web service which talks to a 3rd party weather service .\n" +
                        "It exposes APIs to get weather by city, country and by polar coordinates.")
                .version("1.0").build();
    }

}
