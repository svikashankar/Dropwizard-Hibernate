package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reg_tbl")
public class Registration{

    @Id
    @Column(name = "id", nullable = false)
    @NotNull
    private Integer id;

    @Column(name = "name",length = 45, nullable = false)
    @NotNull
    private String name;

    @Column(name = "email", length = 45, nullable = false)
    @NotNull
    private String email;

    @Column(name = "dob", nullable = false)
    @NotNull
    private Integer dob;

    @Column(name = "gender", length = 45, nullable = false )
    @NotNull
    private String gender;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDob() {
        return dob;
    }

    public void setDob(Integer dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //@Id
//@Column(name = "id", nullable = false)
//@NotNull
//private Integer id;
//
//    @Column(name = "firstName", length = 100, nullable = false)
//    @NotNull
//
//    private String firstName;
//
//    @Column(name = "secondName", length = 100, nullable = false)
//    @NotNull
//    private String secondName;
//
//    @Column(name = "DOB", nullable = false)
//    @NotNull
//    private Integer dob;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getSecondName() {
//        return secondName;
//    }
//
//    public void setSecondName(String secondName) {
//        this.secondName = secondName;
//    }
//
//    public Integer getDob() {
//        return dob;
//    }
//
//    public void setDob(Integer dob) {
//        this.dob = dob;
//    }
}
