/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2;

import com.group2.project2.entities.classesEntity;
import com.group2.project2.entities.markEntity;
import com.group2.project2.entities.semesterEntity;
import com.group2.project2.entities.studentsEntity;
import com.group2.project2.model.classes;
import com.group2.project2.model.mark;
import com.group2.project2.model.semester;
import com.group2.project2.model.students;
import java.util.List;

/**
 *
 * @author nguye
 */
public class StudentController {
    private static students std = null;
    
    public static students stdInstance(){
        if (std == null) std = studentsEntity.findByRollno("HS0002");
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
    
    private static mark m = null;
    public static mark markInstance(){
        if (m == null) m = markEntity.findByRollno(std.getRollno());
        return m;
    }
    
    private static List<students> stdList = null;
    public static List<students> stdListInstance() {
        if (stdList == null) stdList = studentsEntity.findByClassId(std.getClass_id());
        return stdList;
    }
}
