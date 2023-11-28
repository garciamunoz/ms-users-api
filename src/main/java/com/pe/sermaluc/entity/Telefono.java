package com.pe.sermaluc.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_phone")
@Data
public class Telefono implements Serializable {

    private static final long serialVersionUID = -2258003785279670633L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "phonecountrycode")
    private String countryCode;
    @Column(name = "phonecitycode")
    private String cityCode;
    @Column(name = "phonenumber")
    private String number;
}
