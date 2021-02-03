package com.example.weatherService.api.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
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
public class Coord implements Serializable {
    @ApiModelProperty(notes = "City geo location, longitude ")
    public double lon;
    @ApiModelProperty(notes = "City geo location, latitude")
    public double lat;
}
