package com.example.weatherService.api.service;

/**
 * Created by Nasreen Azam Khan on 01/01/2021
 */
public interface CommonLoggingService {


    void logRequest(String uuid, String actionType, Object body);

    void logResponse(String uuid, String actionType, Object body);
}
