package com.pe.sermaluc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorMessage {

    @JsonProperty("mensaje")
    private String mensaje;
}
