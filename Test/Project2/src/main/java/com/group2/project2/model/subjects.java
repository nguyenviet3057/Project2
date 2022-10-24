/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.model;

/**
 *
 * @author ADMIN
 */
public class subjects {
    private int id;
    private String name;
    private int sessions;
    private int staff_id;

    public subjects(int id) {
        this.id = id;
    }

    public subjects(int id, String name, int sessions, int staff_id) {
        this.id = id;
        this.name = name;
        this.sessions = sessions;
        this.staff_id = staff_id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        this.sessions = sessions;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
