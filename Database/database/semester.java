/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author ADMIN
 */
public class semester {
    private int id;
    private int semester_id;
    private int subject_no;
    private String start_year;

    public semester(int id) {
        this.id = id;
    }

    public semester(String start_year) {
        this.start_year = start_year;
    }

    public semester(int id, int semester_id, int subject_no, String start_year) {
        this.id = id;
        this.semester_id = semester_id;
        this.subject_no = subject_no;
        this.start_year = start_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }

    public int getSubject_no() {
        return subject_no;
    }

    public void setSubject_no(int subject_no) {
        this.subject_no = subject_no;
    }

    public String getStart_year() {
        return start_year;
    }

    public void setStart_year(String start_year) {
        this.start_year = start_year;
    }
    
    
}
