package com.example.weatherService.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * Created by Nasreen Azam Khan on 01/01/2021
 */
@Service
@Slf4j
public class CommonLoggingServiceImp implements CommonLoggingService {

    private static Logger logger = LoggerFactory.getLogger(CommonLoggingServiceImp.class);

    public void logRequest(String reqUuid, String actionType, Object body) {

        logger.info("===========================Request begin================================================");
        logger.info("Request UUID         : {}", reqUuid);
        logger.info("Action type        : {}", actionType);
        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper Obj = new ObjectMapper();
        try {
            String jsonStr = Obj.writeValueAsString(body);
            logger.info("Request body: {}", jsonStr);

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        logger.info("==========================Request end================================================");


    }

    public void logResponse(String uuid, String actionType, Object body) {

        ObjectMapper Obj = new ObjectMapper();
        logger.info("=======Response begin===");
        logger.info("Response UUID         : {}", uuid);
        logger.info("Action type        : {}", actionType);
        try {

            String jsonStr = Obj.writeValueAsString(body);

            logger.info("Response body: {}", jsonStr);

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        logger.info("=======Response end===");

    }


}
