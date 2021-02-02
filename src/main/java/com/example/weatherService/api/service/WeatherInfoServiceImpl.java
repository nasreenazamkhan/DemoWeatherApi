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


    @Override
    @Cacheable(value = "infoByCity")
    public WeatherInfoDto fetchByCityAndCountryCode(String city, String countryCode) {
        System.out.println("Entered ******");
        String reqUuid = UUID.randomUUID().toString().substring(0, 8);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("actionTypeReq", "fetchByCityAndCountryCode_req");
        headers.set("actionTypeRes", "fetchByCityAndCountryCode_res");
        headers.set("reqUuid", reqUuid);
        HttpEntity entity = new HttpEntity(headers);

        String cityNameParam = city + "," + countryCode;
        final String baseUrl = requestUrl + "?q=" + cityNameParam + "&appid=" + apiId;
        commonLoggingService.logRequest(reqUuid, "fetchByCityAndCountryCode_req", baseUrl);
        ResponseEntity<WeatherInfoDto> result = restTemplate.getForEntity(baseUrl, WeatherInfoDto.class);
        WeatherInfoDto weatherInfo = result.getBody();
        commonLoggingService.logResponse(reqUuid, "fetchByCityAndCountryCode_res", weatherInfo);
        return weatherInfo;


    }

    @Override
    @Cacheable(value = "infoByCoordinates")
    public WeatherInfoDto fetchByLatitudeAndLongtitude(double lat, double longtitude) {
        String reqUuid = UUID.randomUUID().toString().substring(0, 8);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("actionTypeReq", "fetchByLatitudeAndLongtitude_req");
        headers.set("actionTypeRes", "fetchByLatitudeAndLongtitude_res");
        headers.set("reqUuid", reqUuid);

        HttpEntity entity = new HttpEntity(headers);
        final String baseUrl = requestUrl + "?lat=" + lat + "&lon=" + longtitude + "&appid=" + apiId;
        commonLoggingService.logRequest(reqUuid, "fetchByLatitudeAndLongtitude_req", baseUrl);
        ResponseEntity<WeatherInfoDto> result = restTemplate.getForEntity(baseUrl, WeatherInfoDto.class);
        WeatherInfoDto weatherInfo = result.getBody();
        commonLoggingService.logResponse(reqUuid, "fetchByLatitudeAndLongtitude_res", weatherInfo);
        return weatherInfo;


    }


}



