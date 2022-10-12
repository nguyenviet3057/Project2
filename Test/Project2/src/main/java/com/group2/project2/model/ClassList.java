/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.model;

import com.group2.project2.StudentController;
import com.group2.project2.TeacherController;
import com.group2.project2.entities.attendanceEntity;
import com.group2.project2.entities.classesEntity;
import com.group2.project2.entities.scheduleEntity;
import com.group2.project2.entities.subjectsEntity;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class ClassList extends classes{
    static int count = 0;
    int no;
    String day;
    String time;

    private ClassList(int id, String name, int staff_id, String day, String time) {
        super(id, name, staff_id);
        this.no = ++count;
        this.day = day;
        this.time = time;
    }

    private static List<ClassList> classTable = null;
    
    public static List<ClassList> classTableInstance() {
        if (classTable == null) {
            classTable = new ArrayList<>();
            for (classes cl : classesEntity.findByStaffId(TeacherController.teacherInstance().getId())) {            
                switch (cl.getId()%4) {
                    case 1:
                        classTable.add(new ClassList(cl.getId(), cl.getName(), TeacherController.teacherInstance().getId(), "Monday/Wednesday/Friday", "07:00 - 11:00"));
                        break;
                    case 2:
                        classTable.add(new ClassList(cl.getId(), cl.getName(), TeacherController.teacherInstance().getId(), "Monday/Wednesday/Friday", "13:30 - 17:30"));
                        break;
                    case 3:
                        classTable.add(new ClassList(cl.getId(), cl.getName(), TeacherController.teacherInstance().getId(), "Tuesday/Thursday/Saturday", "07:00 - 11:00"));
                        break;
                    case 0:
                        classTable.add(new ClassList(cl.getId(), cl.getName(), TeacherController.teacherInstance().getId(), "Tuesday/Thursday/Saturday", "13:30 - 17:30"));
                        break;
                }
            }
        }
        return classTable;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        ClassList.count = count;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static List<ClassList> getClassTable() {
        return classTable;
    }

    public static void setClassTable(List<ClassList> classTable) {
        ClassList.classTable = classTable;
    }
    
    
}
