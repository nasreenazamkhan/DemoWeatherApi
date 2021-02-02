package com.example.weatherService.api.controller;


import com.example.weatherService.api.dto.WeatherInfoDto;
import com.example.weatherService.api.service.WeatherInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weatherInfo")
@Api( description = "REST APIs for current weather information", tags = { "Weather Information" })
public class WeatherServiceController {

    @Autowired
    WeatherInfoService weatherInfoService;

    @GetMapping("/fetchByCityAndCountryCode")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @ApiOperation(value = "fetch weather information by city and ISO 3166 country code")
    public ResponseEntity<WeatherInfoDto> fetchByCityAndCountryCode(@RequestParam(name = "city", required = true) String city,
                                                                    @RequestParam(name = "countryCode", required = true) String countryCode) {

        WeatherInfoDto weatherInfo=weatherInfoService.fetchByCityAndCountryCode(city, countryCode);
        return new ResponseEntity<WeatherInfoDto>(weatherInfo, HttpStatus.OK);


    }

    @GetMapping("/fetchByLatitudeLongtitude")
    @ApiOperation(value = "fetch weather information by polar coordinates")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    public ResponseEntity<WeatherInfoDto> fetchByLatitudeAndLongtitude(@RequestParam(name = "latitude", required = true) Double latitude,
                                                                       @RequestParam(name = "longtitude", required = true) Double longtitude) throws JsonProcessingException {

        WeatherInfoDto weatherInfo=weatherInfoService.fetchByLatitudeAndLongtitude(latitude, longtitude);
        return new ResponseEntity<WeatherInfoDto>(weatherInfo, HttpStatus.OK);

    }

}


