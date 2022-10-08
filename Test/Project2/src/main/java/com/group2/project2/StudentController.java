/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2;

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
public class StudentController {
    private static students std = null;
    
    public static students stdInstance(){
        if (std == null) std = studentsEntity.findByRollno("HS0001");
        return std;
    }
    
    private static classes cl = null;
    public static classes classInstance() {
        if (cl == null) cl = classesEntity.findById(std.getClass_id());
        return cl;
    }
    
    private static semester sem = null;
    public static semester semInstance() {
        if (sem == null) sem = semesterEntity.findById(std.getSemester_id());
        return sem;
    }
    private static List<semester> semList = null;
    public static List<semester> semesterListInstance() {
        if (semList == null) semList = semesterEntity.findBySemesterNo(semInstance().getSemester_id());
        return semList;
    }
    
    private static List<mark> markList = null;
    public static List<mark> markListInstance(){
        if (markList == null) markList = markEntity.findByRollno(stdInstance().getRollno());
//        System.out.println(markList.toString());
        return markList;
    }
    
    private static List<students> stdList = null;
    public static List<students> stdListInstance() {
        if (stdList == null) stdList = studentsEntity.findByClassId(std.getClass_id());
//        System.out.println(stdList.toString());
        return stdList;
    }
    
    private static subjects sj = null;
    public static subjects subjectInstance() {
        if (sj == null) sj = subjectsEntity.findByID(semInstance().getSubject_no());
//        System.out.println("subject: " + sj);
        return sj;
    }
    
    private static List<subjects> sjList = null;
    public static List<subjects> subjectListInstance() {
        if (sjList == null) {
            sjList = new ArrayList<>();
            for (semester sem : semesterListInstance()) {
                subjects s = subjectsEntity.findByID(sem.getSubject_no());
//                System.out.println("subject: " + s);
                sjList.add(s);
            }
        }
//        System.out.println("subjectList: " + sjList);
        return sjList;
    }
    
    private static staff sta = null;
    public static staff staffInstance() {
        if (sta == null) sta = staffEntity.findById(subjectInstance().getStaff_id());
//        System.out.println("teacher: " + sta);
        return sta;
    }
    
    private static schedule scd = null;
    public static schedule scheduleInstance() {
        if (scd == null) scd = scheduleEntity.findBySubject_Class(subjectInstance().getId(), classInstance().getId());
//        System.out.println("schedule: " + scd);
        return scd;
    }
    
    private static List<booking> bookList = null;
    public static List<booking> bookingListInstance() {
        if (bookList == null) bookList = bookingEntity.findByScheduleId(scheduleInstance().getId());
//        System.out.println("bookingList: " + scd);
        return bookList;
    }
    
    private static booking bk = null;
    public static booking bookingInstance() {
        for (booking b : bookingListInstance()) {
            if (b.getBegin_time().toLocalDateTime().toLocalDate().equals(LocalDate.now().minusYears(3).minusMonths(5))) {
//                System.out.println("booking: " + bk);
                return b;
            }
        }
//        System.out.println("booking: null");
        return null;
    }
}
