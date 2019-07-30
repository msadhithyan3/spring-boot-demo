/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.exception;

import java.util.Date;

/**
 * @author adithyan
 */
public class ExceptionResponse {

    private Date timeStamp;
    private String messege;
    private String descritpion;

    public ExceptionResponse(Date timeStamp, String messege, String descritpion) {
        this.timeStamp = timeStamp;
        this.messege = messege;
        this.descritpion = descritpion;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }
}
