/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

/**
 *
 * @author ADMIN
 */
public class Subclass {
    private String student_rollno;
    private int class_id;

    public Subclass(String student_rollno) {
        this.student_rollno = student_rollno;
    }
    
    

    public Subclass(String student_rollno, int class_id) {
        this.student_rollno = student_rollno;
        this.class_id = class_id;
    }
    
    

    public String getStudent_rollno() {
        return student_rollno;
    }

    public void setStudent_rollno(String student_rollno) {
        this.student_rollno = student_rollno;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "Subclass{" + "student_rollno=" + student_rollno + ", class_id=" + class_id + '}';
    }
    
    
}
