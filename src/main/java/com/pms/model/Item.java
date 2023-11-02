package com.pms.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

//@Entity
//@Table(name = "device")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @Column(name = "country")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> country;

    @Column(name = "items")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> items;

}
