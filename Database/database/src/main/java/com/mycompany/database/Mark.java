/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author ADMIN
 */
public class Mark {
    private int id;
    private int subject_id;
    private String student_rollno;
    private float mark_t1;
    private float mark_p1;
    private String created_at1;
    private float mark_t2;
    private float mark_p2;
    private String created_at2;

    public Mark(int id) {
        this.id = id;
    }

    public Mark(int id, int subject_id, String student_rollno) {
        this.id = id;
        this.subject_id = subject_id;
        this.student_rollno = student_rollno;
                
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        created_at1 = dateFormat.format(date);
        created_at2 = dateFormat.format(date);
    }


    public Mark(int id, int subject_id, String student_rollno, float mark_t1,
                float mark_p1, String created_at1, float mark_t2, float mark_p2,
                String created_at2) {
        this.id = id;
        this.subject_id = subject_id;
        this.student_rollno = student_rollno;
        this.mark_t1 = mark_t1;
        this.mark_p1 = mark_p1;
        this.created_at1 = created_at1;
        this.mark_t2 = mark_t2;
        this.mark_p2 = mark_p2;
        this.created_at2 = created_at2;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getStudent_rollno() {
        return student_rollno;
    }

    public void setStudent_rollno(String student_rollno) {
        this.student_rollno = student_rollno;
    }

    public float getMark_t1() {
        return mark_t1;
    }

    public void setMark_t1(float mark_t1) {
        this.mark_t1 = mark_t1;
    }

    public float getMark_p1() {
        return mark_p1;
    }

    public void setMark_p1(float mark_p1) {
        this.mark_p1 = mark_p1;
    }

    public String getCreated_at1() {
        return created_at1;
    }

    public void setCreate_at1(String created_at1) {
        this.created_at1 = created_at1;
    }

    public float getMark_t2() {
        return mark_t2;
    }

    public void setMark_t2(float mark_t2) {
        this.mark_t2 = mark_t2;
    }

    public float getMark_p2() {
        return mark_p2;
    }

    public void setMark_p2(float mark_p2) {
        this.mark_p2 = mark_p2;
    }

    public String getCreated_at2() {
        return created_at2;
    }

    public void setCreate_at2(String created_at2) {
        this.created_at2 = created_at2;
    }
    
}
