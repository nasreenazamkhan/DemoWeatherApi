package com.example.weatherService.api.service;


import com.example.weatherService.api.dto.WeatherInfoDto;


/**
 * Created by Nasreen Azam Khan on 01/01/2021
 */
public interface WeatherInfoService {


    WeatherInfoDto fetchByCityAndCountryCode(String city, String countryCode);

    WeatherInfoDto fetchByLatitudeAndLongtitude(double lat, double longtitude);
}
