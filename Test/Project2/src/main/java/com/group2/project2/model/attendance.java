/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.model;

/**
 *
 * @author Darkin
 */
public class attendance {
    private int id;
    private int booking_id;
    private String attendance1;
    private String attendance2;
    private String note;
    private String student_rollno;

    public attendance() {
    }

    public attendance(int id, int booking_id, String attendance1, String attendance2, String note, String student_rollno) {
        this.id = id;
        this.booking_id = booking_id;
        this.attendance1 = attendance1;
        this.attendance2 = attendance2;
        this.note = note;
        this.student_rollno = student_rollno;
    }

    public attendance(int booking_id, String attendance1, String attendance2, String note, String student_rollno) {
        this.booking_id = booking_id;
        this.attendance1 = attendance1;
        this.attendance2 = attendance2;
        this.note = note;
        this.student_rollno = student_rollno;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getAttendance1() {
        return attendance1;
    }

    public void setAttendance1(String attendance1) {
        this.attendance1 = attendance1;
    }

    public String getAttendance2() {
        return attendance2;
    }

    public void setAttendance2(String attendance2) {
        this.attendance2 = attendance2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStudent_rollno() {
        return student_rollno;
    }

    public void setStudent_rollno(String student_rollno) {
        this.student_rollno = student_rollno;
    }
}
