package com.pe.sermaluc.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8044222617130059163L;

    @JsonProperty(value = "name" ,required = true)
    private String name;
    @JsonProperty(value = "email", required = true)
    private String email;
    @JsonProperty(value = "password", required = true)
    private String password;
    @JsonProperty("phones")
    private List<Phone> listPhones;
}
