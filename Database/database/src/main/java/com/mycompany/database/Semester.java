/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

/**
 *
 * @author ADMIN
 */
public class Semester {
    private int id;
    private int semester_no;
    private int subject_id;
    private String start_year;

    public Semester(int id) {
        this.id = id;
    }

    public Semester(String start_year) {
        this.start_year = start_year;
    }

    public Semester(int id, int semester_id, int subject_no, String start_year) {
        this.id = id;
        this.semester_no = semester_no;
        this.subject_id = subject_id;
        this.start_year = start_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemester_no() {
        return semester_no;
    }

    public void setSemester_no(int semester_no) {
        this.semester_no = semester_no;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getStart_year() {
        return start_year;
    }

    public void setStart_year(String start_year) {
        this.start_year = start_year;
    }

    @Override
    public String toString() {
        return "com.mycompany.database.Semester{" +
                "id=" + id +
                ", semester_no=" + semester_no +
                ", subject_id=" + subject_id +
                ", start_year='" + start_year + '\'' +
                '}';
    }
}
