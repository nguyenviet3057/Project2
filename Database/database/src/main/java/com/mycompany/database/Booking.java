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
public class Booking {
    private int id;
    private int schedule_id;
    private String begin_time;
    private String end_time;
    private String note;

    public Booking(int id) {
        this.id = id;
    }

    public Booking(int id, int schedule_id) {
        this.id = id;
        this.schedule_id = schedule_id;
        
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        begin_time = dateFormat.format(date); 
        end_time = dateFormat.format(date);
    }

    
    
    public Booking(int id, int schedule_id, String begin_time, String end_time, String note) {
        this.id = id;
        this.schedule_id = schedule_id;
        this.begin_time = begin_time;
        this.end_time = end_time;
        this.note = note;
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

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
