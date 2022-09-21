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
public class notification {
    private int id;
    private int staff_id;
    private String content;
    private TimeUnit created_at;
    private TimeUnit updated_at;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TimeUnit getCreated_at() {
        return created_at;
    }

    public void setCreated_at(TimeUnit created_at) {
        this.created_at = created_at;
    }

    public TimeUnit getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(TimeUnit updated_at) {
        this.updated_at = updated_at;
    }
    
    
}
