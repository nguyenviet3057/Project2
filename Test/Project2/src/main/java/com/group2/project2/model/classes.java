/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.model;

/**
 *
 * @author ADMIN
 */
public class classes {
    private int id;
    private String name;
    private int n_std;
    private int staff_id;

    public classes() {
    }

    public classes(int id, String name, int n_std, int staff_id) {
        this.id = id;
        this.name = name;
        this.n_std = n_std;
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

    public int getN_std() {
        return n_std;
    }

    public void setN_std(int n_std) {
        this.n_std = n_std;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }
    
    
}
