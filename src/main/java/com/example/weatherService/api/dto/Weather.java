package com.example.weatherService.api.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Weather implements Serializable {

    @ApiModelProperty(notes = " Weather condition id ")
    public int id;
    @ApiModelProperty(notes = "Group of weather parameters (Rain, Snow, Extreme etc.)")
    public String main;
    @ApiModelProperty(notes = "Weather condition within the group (String)")
    public String description;
    @ApiModelProperty(notes = "Weather icon id (String)")
    public String icon;
}
