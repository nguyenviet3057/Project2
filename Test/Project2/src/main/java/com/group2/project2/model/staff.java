/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.model;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author ADMIN
 */
public class staff {
    private int id;
    private String fullname;
    private String  birthday;
    private String phonenumber;
    private String address;
    private String email;
    private String password;
    private String picture;
    private float salary;
    private int permission_id;

    public staff(int id) {
        this.id = id;
    }

    public staff(String fullname) {
        this.fullname = fullname;
    }

    public staff(int id, String fullname, String birthday, String phonenumber, 
            String address, String email, String password, String picture, 
            float salary, int permission_id) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        this.password = password;
        this.picture = picture;
        this.salary = salary;
        this.permission_id = permission_id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    @Override
    public String toString() {
        return "staff{" + "id=" + id + ", fullname=" + fullname + ", birthday="
                + birthday + ", phonenumber=" + phonenumber + ", address=" + 
                address + ", email=" + email + ", password=" + password + ", "
                + "picture=" + picture + ", salary=" + salary + ", "
                + "permission_id=" + permission_id + '}';
    }
    
    
}
