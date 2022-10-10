/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Schedule {
    private int id;
    private int staff_id;
    private int subject_id;
    private int class_id;
    private String start_date;
    private String end_date;

    public Schedule(int id) {
        this.id = id;
    }

    public Schedule(int staff_id, int subject_id) {
        this.staff_id = staff_id;
        this.subject_id = subject_id;
        
        Date date = Calendar.getInstance().getTime(); 
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        start_date = dateFormat.format(date);  
        end_date = dateFormat.format(date);
    }

    public Schedule(int id, int staff_id, int subject_id, int class_id, String start_date, String end_date) {
        this.id = id;
        this.staff_id = staff_id;
        this.subject_id = subject_id;
        this.class_id = class_id;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    
    
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
    
    
}
