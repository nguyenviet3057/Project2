package com.group2.project2.model;

import com.group2.project2.StudentController;
import com.group2.project2.TeacherController;
import com.group2.project2.entities.attendanceEntity;
import com.group2.project2.entities.scheduleEntity;
import com.group2.project2.entities.studentsEntity;
import com.group2.project2.model.students;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class StudentList extends students {
    static int count = 0;
    int no;
    float totalAbsent;
    List<String> attendance1;
    List<String> attendance2;

    private StudentList(String rollno, String fullname, Date birthday, String phonenumber, String address, String Email, String password, String picture, int status_id, int semester_id, int class_id, String gender, float totalAbsent) {
        super(rollno, fullname, birthday, phonenumber, address, Email, password, picture, status_id, semester_id, class_id, gender);
        this.no = ++count;
        this.totalAbsent = totalAbsent;
        attendance1 = new ArrayList<>();
        attendance2 = new ArrayList<>();
    }

    private static List<StudentList> stdTable = null;
    
    public static List<StudentList> stdTableInstance(int role) {
        if (stdTable == null) {
            
//            ObservableList dayOfWeek = FXCollections.observableArrayList("P", "PA", "A");
            stdTable = new ArrayList<>();
            List<students> stdList = new ArrayList<>();
            schedule sch = null;
            switch (role) {
                case 0:
                    stdList = StudentController.stdListInstance();
                    sch = StudentController.scheduleInstance();
                    break;
                case 1:
                    stdList = studentsEntity.findByClassId(TeacherController.getBookingClassId());
                    sch = scheduleEntity.findBySubject_Class(TeacherController.subjectListInstance().get(0).getId(), TeacherController.getBookingClassId());
            }
            for (students student : stdList) {                
                StudentList stdElement = new StudentList(student.getRollno(), student.getFullname(), student.getBirthday(), student.getPhonenumber(), student.getAddress(), student.getEmail(), student.getPassword(), student.getPicture(), student.getStatus_id(), student.getSemester_id(), student.getClass_id(), student.getGender(), 0);
                float _totalAbsent = 0;
//                int session1 = 0;
//                int session2 = 0;
//                HashMap<Number,  ComboBox> _attendance1 = new HashMap<>();
//                HashMap<Number, ComboBox> _attendance2 = new HashMap<>();
                for (attendance atd : attendanceEntity.totalPresentByScheduleId_StudentRollno(sch.getId() ,student.getRollno())) {
//                    System.out.println("Added");
                    if (atd.getAttendance1().compareTo("PA")==0) {
//                        _attendance1.put(++session1, new ComboBox(dayOfWeek));
                        stdElement.getAttendance1().add("PA");
                        _totalAbsent++;
                    }
                    if (atd.getAttendance1().compareTo("A")==0) {
                        stdElement.getAttendance1().add("A");
                        _totalAbsent++;
                    }
                    if (atd.getAttendance1().compareTo("P")==0) {
                        stdElement.getAttendance1().add("P");
                    }
                    if (atd.getAttendance2().compareTo("PA")==0) {
                        stdElement.getAttendance2().add("PA");
                        _totalAbsent++;
                    }
                    if (atd.getAttendance2().compareTo("A")==0) {
                        stdElement.getAttendance2().add("A");
                        _totalAbsent++;
                    }
                    if (atd.getAttendance2().compareTo("P")==0) {
                        stdElement.getAttendance2().add("P");
                    }
                }
                stdElement.setTotalAbsent(_totalAbsent/2);
                stdTable.add(stdElement);
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

    public List<String> getAttendance1() {
        return attendance1;
    }

    public void setAttendance1(List<String> attendance1) {
        this.attendance1 = attendance1;
    }

    public List<String> getAttendance2() {
        return attendance2;
    }

    public void setAttendance2(List<String> attendance2) {
        this.attendance2 = attendance2;
    }

    public static List<StudentList> getStdTable() {
        return stdTable;
    }

    public static void setStdTable(List<StudentList> stdTable) {
        StudentList.stdTable = stdTable;
    }
    
}