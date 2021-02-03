package com.example.weatherService.api.service;


import com.example.weatherService.api.dto.WeatherInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * Created by Nasreen Azam Khan on 01/01/2021
 */
@Service("weatherInfoService")
@Slf4j
public class WeatherInfoServiceImpl implements WeatherInfoService {

    private static Logger logger = LoggerFactory.getLogger(WeatherInfoServiceImpl.class);


    @Value("${weather_by_city_url}")
    public String requestUrl;

    @Value("${api_key}")
    public String apiId;

    @Autowired
    CommonLoggingService commonLoggingService;


    RestTemplate restTemplate;

    @Autowired
    public WeatherInfoServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    /**
     * This method fetches weather information by city name and country code (ISO 3166)
     * @param  city city name
     * @param  countryCode ISO 3166 country code
     * @return WeatherInfoDto
     */
    @Override
    @Cacheable(value = "infoByCity")
    public WeatherInfoDto fetchByCityAndCountryCode(String city, String countryCode) {
        String reqUuid = UUID.randomUUID().toString().substring(0, 8);
        String cityNameParam = city + "," + countryCode;
        final String baseUrl = requestUrl + "?q=" + cityNameParam + "&appid=" + apiId;
        commonLoggingService.logRequest(reqUuid, "fetchByCityAndCountryCode_req", baseUrl);
        ResponseEntity<WeatherInfoDto> result = restTemplate.getForEntity(baseUrl, WeatherInfoDto.class);
        WeatherInfoDto weatherInfo = result.getBody();
        commonLoggingService.logResponse(reqUuid, "fetchByCityAndCountryCode_res", weatherInfo);
        return weatherInfo;


    }

    /**
     * This method fetches weather information by polar cordinates
     * @param  lat latitude of location
     * @param  longtitude longtitude of location
     * @return WeatherInfoDto
     */
    @Override
    @Cacheable(value = "infoByCoordinates")
    public WeatherInfoDto fetchByLatitudeAndLongtitude(double lat, double longtitude) {
        String reqUuid = UUID.randomUUID().toString().substring(0, 8);
        final String baseUrl = requestUrl + "?lat=" + lat + "&lon=" + longtitude + "&appid=" + apiId;
        //logging the request
        commonLoggingService.logRequest(reqUuid, "fetchByLatitudeAndLongtitude_req", baseUrl);
        ResponseEntity<WeatherInfoDto> result = restTemplate.getForEntity(baseUrl, WeatherInfoDto.class);
        WeatherInfoDto weatherInfo = result.getBody();
        //logging the response
        commonLoggingService.logResponse(reqUuid, "fetchByLatitudeAndLongtitude_res", weatherInfo);
        return weatherInfo;


    }


}



