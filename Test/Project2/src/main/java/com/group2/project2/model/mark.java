/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class mark {
    private int id;
    private int subject_id;
    private String student_rollno;
    private int mark_t1;
    private int mark_p1;
    private Date create_at1;
    private int mark_t2;
    private int mark_p2;
    private Date create_at2;

    public mark() {
    }
    
    public mark(int id, int subject_id, String student_rollno, int mark_t1, int mark_p1, Date create_at1, int mark_t2, int mark_p2, Date create_at2) {
        this.id = id;
        this.subject_id = subject_id;
        this.student_rollno = student_rollno;
        this.mark_t1 = mark_t1;
        this.mark_p1 = mark_p1;
        this.create_at1 = create_at1;
        this.mark_t2 = mark_t2;
        this.mark_p2 = mark_p2;
        this.create_at2 = create_at2;
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

    public int getMark_t1() {
        return mark_t1;
    }

    public void setMark_t1(int mark_t1) {
        this.mark_t1 = mark_t1;
    }

    public int getMark_p1() {
        return mark_p1;
    }

    public void setMark_p1(int mark_p1) {
        this.mark_p1 = mark_p1;
    }

    public Date getCreate_at1() {
        return create_at1;
    }

    public void setCreate_at1(Date create_at1) {
        this.create_at1 = create_at1;
    }

    public int getMark_t2() {
        return mark_t2;
    }

    public void setMark_t2(int mark_t2) {
        this.mark_t2 = mark_t2;
    }

    public int getMark_p2() {
        return mark_p2;
    }

    public void setMark_p2(int mark_p2) {
        this.mark_p2 = mark_p2;
    }

    public Date getCreate_at2() {
        return create_at2;
    }

    public void setCreate_at2(Date create_at2) {
        this.create_at2 = create_at2;
    }
    
}
