package com.fms.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
//@Table(name = "device")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "model")
    private String model;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "carrier")
    private String carrier;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "firmware")
    private String firmware;

}