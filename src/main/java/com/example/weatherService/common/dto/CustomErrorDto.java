package com.example.weatherService.common.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * Created by Nasreen Azam Khan on 01/01/2021
 */
@Data
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CustomErrorDto {
    int status ;
    String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;


    public CustomErrorDto(int status,  String message, LocalDateTime time ) {
        super();
        this.status = status;
        this.message = message;
        this.timestamp = time;

    }

}


