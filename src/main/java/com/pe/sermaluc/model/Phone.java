package com.pe.sermaluc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Phone implements Serializable {

    private static final long serialVersionUID = 3781149809264727862L;
    @JsonProperty("number")
    private String number;
    @JsonProperty("citycode")
    private String cityCode;
    @JsonProperty("contrycode")
    private String countryCode;

}
