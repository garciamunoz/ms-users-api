package com.pe.sermaluc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Phone implements Serializable {

    private static final long serialVersionUID = 3781149809264727862L;
    @JsonProperty(value = "number",required = true)
    private String number;
    @JsonProperty(value = "citycode",required = true)
    private String cityCode;
    @JsonProperty(value = "contrycode",required = true)
    private String countryCode;

}
