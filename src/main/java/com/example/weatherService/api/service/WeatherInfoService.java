package com.example.weatherService.api.service;


import com.example.weatherService.api.dto.WeatherInfoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

public interface WeatherInfoService {


    WeatherInfoDto fetchByCityAndCountryCode(String city, String countryCode) ;

    WeatherInfoDto fetchByLatitudeAndLongtitude(double lat, double longtitude) ;
}
