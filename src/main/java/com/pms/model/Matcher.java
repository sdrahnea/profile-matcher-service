package com.pms.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
//@Table(name = "matcher")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Matcher {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "name")
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Level level;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Item has;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Item does_not_have;

}
