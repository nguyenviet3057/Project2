/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author ADMIN
 */
public class booking {
    private int id;
    private int schedule_id;
    private TimeUnit begin_time;
    private TimeUnit end_time;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public TimeUnit getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(TimeUnit begin_time) {
        this.begin_time = begin_time;
    }

    public TimeUnit getEnd_time() {
        return end_time;
    }

    public void setEnd_time(TimeUnit end_time) {
        this.end_time = end_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
