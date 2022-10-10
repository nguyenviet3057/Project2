/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

/**
 *
 * @author ADMIN
 */
public class Subjects {
    private int id;
    private String name;
    private int staff_id;
    private int sessions;

    public Subjects(int id) {
        this.id = id;
    }

    public Subjects(int id, String name, int sessions, int staff_id) {
        this.id = id;
        this.name = name;
        this.staff_id = staff_id;
        this.sessions = sessions;
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

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }
    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        this.sessions = sessions;
    }



    @Override
    public String toString() {
        return "Subjects{" + "id=" + id + ", name=" + name + ", staff_id=" + staff_id +", sessions=" + sessions +  '}';
    }
    
    
}
