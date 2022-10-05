package com.group2.project2.model;

import com.group2.project2.StudentController;
import com.group2.project2.model.students;
import java.util.ArrayList;
import java.util.List;

public class StudentList extends students {
    static int count = 0;
    int no;

    private StudentList(String rollno, String fullname, String birthday, String phonenumber, String address, String Email, String password, String picture, int status_id, int semester_id, int class_id) {
        super(rollno, fullname, birthday, phonenumber, address, Email, password, picture, status_id, semester_id, class_id);
        this.no = ++count;
    }

    private static List<StudentList> stdTable = null;
    
    public static List<StudentList> stdTableInstance() {
        if (stdTable == null) {
            stdTable = new ArrayList<>();
            for (students student : StudentController.stdListInstance()) {
                stdTable.add(new StudentList(student.getRollno(), student.getFullname(), student.getBirthday(), student.getPhonenumber(), student.getAddress(), student.getEmail(), student.getPassword(), student.getPicture(), student.getStatus_id(), student.getSemester_id(), student.getClass_id()));
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
}