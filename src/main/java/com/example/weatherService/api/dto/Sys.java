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
public class Sys implements Serializable {
    @ApiModelProperty(notes = " Internal parameter (Integer)")
    public int type;
    @ApiModelProperty(notes = " Internal parameter (Integer)")
    public int id;
    @ApiModelProperty(notes = " Country Code  (String)")
    public String country;
    @ApiModelProperty(notes = " Sunrise  time  ")
    public int sunrise;
    @ApiModelProperty(notes = " Sunset  time ")
    public int sunset;
}
