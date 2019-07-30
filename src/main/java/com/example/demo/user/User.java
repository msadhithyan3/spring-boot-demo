/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.user;

import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * @author adithyan
 */
public class User {

    private Integer id;
    @Size(min = 2, message = "minimum 2 characters need")
    private String name;
    @Past(message = "date of birth should be in past")
    private Date dateofBirthDate;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", dateofBirthDate=" + dateofBirthDate + '}';
    }

    protected User() {

    }

    public User(Integer id, String name, Date dateofBirthDate) {
        this.id = id;
        this.name = name;
        this.dateofBirthDate = dateofBirthDate;
    }

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

    public Date getDateofBirthDate() {
        return dateofBirthDate;
    }

    public void setDateofBirthDate(Date dateofBirthDate) {
        this.dateofBirthDate = dateofBirthDate;
    }
}
