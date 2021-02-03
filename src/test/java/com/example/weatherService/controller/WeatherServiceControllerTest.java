package com.example.weatherService.controller;

import com.example.weatherService.api.dto.WeatherInfoDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
public class WeatherServiceControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void fetchByCityAndCountryCode_success() {
        String city = "London";
        String countryCode = "uk";
        ResponseEntity<WeatherInfoDto> responseEntity =
                testRestTemplate
                        .getForEntity("/weatherInfo/fetchByCityAndCountryCode?city="+city +"&countryCode=" +countryCode , WeatherInfoDto.class);
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    public void fetchByCityAndCountryCode_NOT_FOUND() {
        String city = "London";
        String countryCode = "in";
        ResponseEntity<WeatherInfoDto> responseEntity =
                testRestTemplate
                        .getForEntity("/weatherInfo/fetchByCityAndCountryCode?city="+city +"&countryCode=" +countryCode , WeatherInfoDto.class);
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

    }



}
