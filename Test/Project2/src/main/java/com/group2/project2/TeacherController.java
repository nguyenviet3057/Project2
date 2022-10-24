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
public class TeacherController {
    
    public static int id;
    
    public static staff teacherInstance(){
        if (teacher == null) teacher = staffEntity.findById(id);
        return teacher;
    }
    
    private static boolean isRollUp = false;
    public static boolean isIsRollUp() {
        return isRollUp;
    }
    public static void setIsRollUp(boolean isRollUp) {
        TeacherController.isRollUp = isRollUp;
    }
    
    private static staff teacher = null;
    
    private static int currentSession = 0;
    public static int getCurrentSession() {
//        System.out.println("current: " + currentSession);
        return currentSession;
    }
    public static int currentSessionInstance() {
        if (currentSession == 0) return 0;
        return currentSession;
    }
    public static void setCurrentSession(int currentSession) {
        if (TeacherController.currentSession == 0) {
//            System.out.println("Set currenSession");
            TeacherController.currentSession = currentSession;
        }
    }
    
    private static int teachSession = 0;
    public static int getTeachSession() {
        return currentSession+1;
    }
    public static void setTeachSession(int teachSession) {
        TeacherController.teachSession = teachSession;
    }
    
    private static int displaySession = 0;
    public static int getDisplaySession() {
        if (displaySession == 0) return currentSession;
        return displaySession;
    }
    public static void setDisplaySession(int teachSession) {
        TeacherController.displaySession = teachSession;
    }
    
    private static int curentSchedule = scheduleEntity.findBySubject_Class(1, 1).getId();
    public static int getCurentSchedule() {
        return curentSchedule;
    }
    public static void setCurentSchedule(int curentSchedule) {
        TeacherController.curentSchedule = curentSchedule;
    }
    
    private static int bookingClassId;
    public static int getBookingClassId() {
        return bookingClassId;
    }
    public static void setBookingClassId(int bookingClassId) {
        TeacherController.bookingClassId = bookingClassId;
    }
    
    private static List<classes> classList = null;
    public static List<classes> classInstance() {
        if (classList == null) classList = classesEntity.findByStaffId(id);
        return classList;
    }
    
    private static List<subjects> sjList = null;
    public static List<subjects> subjectListInstance() {
        if (sjList == null) sjList = subjectsEntity.findByStaffId(id);
//        System.out.println("subjectList: " + sjList);
        return sjList;
    }
    
    public static void resetData() {
        id = 0;
        isRollUp = false;
        teacher = null;
        currentSession = 0;
        teachSession = 0;
        displaySession = 0;
//        curentSchedule = 0;
        bookingClassId = 0;
        classList = null;
        sjList = null;
    }
}
