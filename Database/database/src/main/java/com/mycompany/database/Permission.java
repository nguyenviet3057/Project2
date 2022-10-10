/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

/**
 *
 * @author ADMIN
 */
public class Permission {
    private int id;
    private String role;

    public Permission(int id) {
        this.id = id;
    }

    public Permission(String role) {
        this.role = role;
    }
    
    

    public Permission(int id, String role) {
        this.id = id;
        this.role = role;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
