package com.fms.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
//@Table(name = "inventory")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "cash")
    private Long cash;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "coins")
    private Long coins;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "item_1")
    private Long item_1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "item_34")
    private Long item_34;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "item_55")
    private Long item_55;

}
