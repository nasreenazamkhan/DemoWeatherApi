package com.example.weatherService.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherInfoDto implements Serializable {
    @ApiModelProperty(notes = " Coordinates ")
    public Coord coord;
    @ApiModelProperty(notes = " Weather Information")
    public List<Weather> weather;
    @ApiModelProperty(notes = " Internal paramter")
    public String base;
    public Main main;
    @ApiModelProperty(notes = " Visibility meter ")
    public int visibility;
    public Wind wind;
    public Snow snow;
    public Rain rain;
    public Clouds clouds;
    @ApiModelProperty(notes = " Time of data calculation  ")
    public int dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    @ApiModelProperty(notes = " Code ")
    public int cod;


}
