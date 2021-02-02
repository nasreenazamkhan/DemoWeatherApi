package com.example.weatherService.api.service;


public interface CommonLoggingService {


    void logRequest(String uuid, String actionType, Object body);

    void logResponse(String uuid, String actionType, Object body);
}
