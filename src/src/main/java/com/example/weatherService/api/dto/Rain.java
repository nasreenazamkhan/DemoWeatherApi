package com.example.weatherService.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * Created by Nasreen Azam Khan on 01/01/2021
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rain implements Serializable {
    @JsonProperty("1h")
    @ApiModelProperty(notes = " Rain volume ")
    public double oneHour;
}
