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
public class Main implements Serializable {
    @ApiModelProperty(notes = "Temperature unit ")
    public double temp;
    @ApiModelProperty(notes = "Temperature feels like ")
    public double feels_like;
    @ApiModelProperty(notes = "Minimum temperature ")
    public double temp_min;
    @ApiModelProperty(notes = "Maximum Temperature ")
    public double temp_max;
    @ApiModelProperty(notes = "Atmospheric pressure ")
    public int pressure;
    @ApiModelProperty(notes = "Humidity % ")
    public int humidity;
}
