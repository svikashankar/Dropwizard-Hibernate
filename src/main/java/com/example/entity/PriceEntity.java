package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@NamedQueries(
//        @NamedQuery(
//                name =PriceEntity.ALL_PRICE,
//                query = "select p from PriceEntity p"
//
//        )
//
//)
@Entity
@Table(name = "PRICE")
public class PriceEntity {
//    public static final String ALL_PRICE = "getAllPRICE";

    @Id
    @Column(name = "id", nullable = false)
    @NotNull
    @JsonProperty
    private Integer id;

    @Column(name = "name", length = 100, nullable = false)
    @NotNull
    @JsonProperty
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
