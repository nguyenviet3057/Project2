/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.model;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ADMIN
 */
public class students {
    private String rollno;
    private String fullname;
    private Date birthday;
    private String phonenumber;
    private String address;
    private String email;
    private String password;
    private String picture;
    private int status_id;
    private int semester_id;
    private int class_id;
    private String gender;

    public students(String rollno) {
        this.rollno = rollno;
    }

    public students(String rollno, String fullname, Date birthday, 
            String phonenumber, String address, String email, String password, 
            String picture, int status_id, int semester_id, int class_id, String gender) {
        this.rollno = rollno;
        this.fullname = fullname;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        this.password = password;
        this.picture = picture;
        this.status_id = status_id;
        this.semester_id = semester_id;
        this.class_id = class_id;
        this.gender = gender;
    }

    
    
    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "students{" + "rollno=" + rollno + ", fullname=" + fullname + 
                ", birthday=" + birthday + ", phonenumber=" + phonenumber + 
                ", address=" + address + ", email=" + email + ", password=" + 
                password + ", picture=" + picture + ", status_id=" + status_id + 
                ", semester_id=" + semester_id + ", class_id=" + class_id + ", gender=" + gender + '}';
    }
    
    
}
