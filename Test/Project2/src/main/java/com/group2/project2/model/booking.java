/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.model;

import java.sql.Timestamp;

/**
 *
 * @author ADMIN
 */
public class booking {
    private int id;
    private int schedule_id;
    private Timestamp begin_time;
    private Timestamp end_time;
    private String note;

    public booking() {
    }
    
    public booking(int id, int schedule_id, Timestamp begin_time, Timestamp end_time) {
        this.id = id;
        this.schedule_id = schedule_id;
        this.begin_time = begin_time;
        this.end_time = end_time;
        this.note = "";
    }
    
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

    public Timestamp getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Timestamp begin_time) {
        this.begin_time = begin_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
