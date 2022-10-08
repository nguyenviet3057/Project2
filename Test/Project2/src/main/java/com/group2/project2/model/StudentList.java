package com.group2.project2.model;

import com.group2.project2.StudentController;
import com.group2.project2.entities.attendanceEntity;
import com.group2.project2.model.students;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StudentList extends students {
    static int count = 0;
    int no;
    float totalAbsent;

    private StudentList(String rollno, String fullname, Date birthday, String phonenumber, String address, String Email, String password, String picture, int status_id, int semester_id, int class_id, String gender, float totalAbsent) {
        super(rollno, fullname, birthday, phonenumber, address, Email, password, picture, status_id, semester_id, class_id, gender);
        this.no = ++count;
        this.totalAbsent = totalAbsent;
    }

    private static List<StudentList> stdTable = null;
    
    public static List<StudentList> stdTableInstance() {
        if (stdTable == null) {
            stdTable = new ArrayList<>();
            for (students student : StudentController.stdListInstance()) {
                float _totalAbsent = 0;
                for (attendance atd : attendanceEntity.totalPresentByScheduleId_StudentRollno(StudentController.scheduleInstance().getId(), student.getRollno())) {
                    if (atd.getAttendance1().compareTo("PA")==0 || atd.getAttendance1().compareTo("A")==0) _totalAbsent++;
                    if (atd.getAttendance2().compareTo("PA")==0 || atd.getAttendance2().compareTo("A")==0) _totalAbsent++;
                }
                stdTable.add(new StudentList(student.getRollno(), student.getFullname(), student.getBirthday(), student.getPhonenumber(), student.getAddress(), student.getEmail(), student.getPassword(), student.getPicture(), student.getStatus_id(), student.getSemester_id(), student.getClass_id(), student.getGender(), _totalAbsent/2));
            }
        }
        return stdTable;
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        StudentList.count = count;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public float getTotalAbsent() {
        return totalAbsent;
    }

    public void setTotalAbsent(float totalAbsent) {
        this.totalAbsent = totalAbsent;
    }
}