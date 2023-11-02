package com.pms.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

//@Entity
//@Table(name = "campaign")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "game")
    private String game;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "name")
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "priority")
    private Double priority;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "start_date")
    private Instant start_date;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "end_date")
    private Instant end_date;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "enabled")
    private Boolean enabled;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "last_updated")
    private Instant last_updated;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Matcher matchers;

}