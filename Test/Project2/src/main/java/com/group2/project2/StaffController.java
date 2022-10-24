package com.group2.project2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.group2.project2.entities.bookingEntity;
import com.group2.project2.entities.classesEntity;
import com.group2.project2.entities.markEntity;
import com.group2.project2.entities.scheduleEntity;
import com.group2.project2.entities.semesterEntity;
import com.group2.project2.entities.staffEntity;
import com.group2.project2.entities.studentsEntity;
import com.group2.project2.entities.subjectsEntity;
import com.group2.project2.model.ClassList;
import com.group2.project2.model.booking;
import com.group2.project2.model.classes;
import com.group2.project2.model.mark;
import com.group2.project2.model.schedule;
import com.group2.project2.model.semester;
import com.group2.project2.model.staff;
import com.group2.project2.model.students;
import com.group2.project2.model.subjects;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class StaffController {
    
    public static int id;
    
    private static staff sta = null;    
    public static staff staffInstance(){
        if (sta == null) sta = staffEntity.findById(id);
        return sta;
    }
    
    private static List<ClassList> classList = null;
    public static List<ClassList> classInstance() {
        if (classList == null) classList = ClassList.classTableInstance(3);
        return classList;
    }
    
    private static int currentClassId;
    public static int getCurrentClassId() {
        return currentClassId;
    }
    public static void setCurrentClassId(int currentClassId) {
        StaffController.currentClassId = currentClassId;
    }
    
    public static void resetData() {
        id = 0;
        sta = null;
        classList = null;
        currentClassId = 0;
    }
}
