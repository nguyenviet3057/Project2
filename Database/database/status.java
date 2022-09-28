/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

/**
 *
 * @author ADMIN
 */
public class status {
    private int id;
    private String desc;

    public status(int id) {
        this.id = id;
    }

    public status(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public status(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "status{" + "id=" + id + ", desc=" + desc + '}';
    }
    
    
}
