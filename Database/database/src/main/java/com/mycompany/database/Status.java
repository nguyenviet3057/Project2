/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

/**
 *
 * @author ADMIN
 */
public class Status {
    private int id;
    private String describe;

    public Status(int id) {
        this.id = id;
    }

    public Status(int id, String desc) {
        this.id = id;
        this.describe = describe;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String desc) {
        this.describe = describe;
    }

    public Status(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Status{" + "id=" + id + ", desc=" + describe + '}';
    }
    
    
}
