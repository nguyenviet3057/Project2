/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.model;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class classes {
    private int id;
    private String name;
    private int semester_id;
    private int staff_id;

    public classes() {
    }

    public classes(int id, String name, int semester_id, int staff_id) {
        this.id = id;
        this.name = name;
        this.semester_id = semester_id;
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

    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }
    
    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }    
    
}
