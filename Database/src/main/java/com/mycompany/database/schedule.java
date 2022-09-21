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
public class schedule {
    private int id;
    private int staff_id;
    private int subject_id;
    private int class_id;
    private TimeUnit start_date;
    private TimeUnit end_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public TimeUnit getStart_date() {
        return start_date;
    }

    public void setStart_date(TimeUnit start_date) {
        this.start_date = start_date;
    }

    public TimeUnit getEnd_date() {
        return end_date;
    }

    public void setEnd_date(TimeUnit end_date) {
        this.end_date = end_date;
    }
    
    
}
