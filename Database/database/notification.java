/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;


/**
 *
 * @author ADMIN
 */
public class notification {
    private int id;
    private int staff_id;
    private String content;
    private String created_at;
    private String updated_at;

    public notification(int id) {
        this.id = id;
    }

    public notification(int id, int staff_id, String content, String created_at, 
            String updated_at) {
        this.id = id;
        this.staff_id = staff_id;
        this.content = content;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    
    
}
