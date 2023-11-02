package com.pms.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Entity
//@Table(name = "player")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "player_id")
    private String player_id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "credential")
    private String credential;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "created")
    private Instant created;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "modified")
    private Instant modified;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "last_session")
    private Instant last_session;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "total_spent")
    private Integer total_spent;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "total_refund")
    private Integer total_refund;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "total_transactions")
    private Integer total_transactions;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "last_purchase")
    private Instant last_purchase;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "active_campaigns")
    private List<String> active_campaigns;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Device> devices;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "level")
    private Integer level;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "xp")
    private Integer xp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "total_playtime")
    private Long total_playtime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "country")
    private String country;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "language")
    private String language;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "birth_date")
    private Instant birthDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "gender")
    private String gender;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, Object> inventory = new HashMap<>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "_customfield")
    private String customfield;


}

