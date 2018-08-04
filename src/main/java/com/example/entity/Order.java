package com.example.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@NamedQueries(
//        @NamedQuery(
//                name =Order.GETALL,
//                query = "select o from Order o"
//
//        )

//)
@Entity
@Table(name = "order_tbl")
public class Order {

//    public static final String GETALL = "getallOrder";

    @Id
    @Column(name = "id", nullable = false)
    @NotNull
    private Integer id;

    @Column(name = "firstName", length = 100, nullable = false)
    @NotNull

    private String firstName;

    @Column(name = "secondName", length = 100, nullable = false)
    @NotNull
    private String secondName;

    @Column(name = "DOB", nullable = false)
    @NotNull
    private Integer dob;

    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getDob() {
        return dob;
    }

    public void setDob(Integer dob) {
        this.dob = dob;
    }
}
