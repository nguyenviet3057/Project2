package com.group2.project2.model;

import com.group2.project2.StudentController;
import static com.group2.project2.StudentController.stdInstance;
import com.group2.project2.TeacherController;
import com.group2.project2.entities.attendanceEntity;
import com.group2.project2.entities.markEntity;
import com.group2.project2.entities.scheduleEntity;
import com.group2.project2.entities.studentsEntity;
import com.group2.project2.entities.subjectsEntity;
import com.group2.project2.model.students;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;

public class StudentList extends students {
    static int count = 0;
    int no;
    float totalAbsent;
    List<String> attendance1;
    List<String> attendance2;
    int theory;
    int practice;

    public int getTheory() {
        return theory;
    }

    public void setTheory(int theory) {
        this.theory = theory;
    }

    public int getPractice() {
        return practice;
    }

    public void setPractice(int practice) {
        this.practice = practice;
    }

    private StudentList(String rollno, String fullname, Date birthday, String phonenumber, String address, String Email, String password, String picture, int status_id, int semester_id, int class_id, String gender, float totalAbsent) {
        super(rollno, fullname, birthday, phonenumber, address, Email, password, picture, status_id, semester_id, class_id, gender);
        this.no = ++count;
        this.totalAbsent = totalAbsent;
        attendance1 = new ArrayList<>();
        attendance2 = new ArrayList<>();
    }
    
    public StudentList(int no, String rollno, String fullname, Date birthday, String phonenumber, String address, String Email, String password, String picture, int status_id, int semester_id, int class_id, String gender, float totalAbsent, List<String> attendance1, List<String> attendance2) {
        super(rollno, fullname, birthday, phonenumber, address, Email, password, picture, status_id, semester_id, class_id, gender);
        this.no = no;
        this.totalAbsent = totalAbsent;
        this.attendance1 = attendance1;
        this.attendance2 = attendance2;
    }
    
    private static List<mark> markList = null;
    public static List<mark> markListInstance(String rollno){
        if (markList == null) markList = markEntity.findByRollno(rollno);
//        System.out.println(markList.toString());
        return markList;
    }

    private static List<StudentList> stdTable = null;
    
    public static List<StudentList> stdTableInstance(int class_id) {
        if (stdTable == null) {
            
//            ObservableList dayOfWeek = FXCollections.observableArrayList("P", "PA", "A");
            stdTable = new ArrayList<>();
            List<students> stdList = studentsEntity.findByClassId(class_id);
            schedule scd = null;
            scd = (StudentController.stdInstance() == null)? scd : StudentController.scheduleInstance();
            scd = (TeacherController.teacherInstance() == null)? scd : scheduleEntity.findBySubject_Class(TeacherController.subjectListInstance().get(0).getId(), TeacherController.getBookingClassId());
            for (students student : stdList) {                
                StudentList stdElement = new StudentList(student.getRollno(), student.getFullname(), student.getBirthday(), student.getPhonenumber(), student.getAddress(), student.getEmail(), student.getPassword(), student.getPicture(), student.getStatus_id(), student.getSemester_id(), student.getClass_id(), student.getGender(), 0);
                float _totalAbsent = 0;
//                int session1 = 0;
//                int session2 = 0;
//                HashMap<Number,  ComboBox> _attendance1 = new HashMap<>();
//                HashMap<Number, ComboBox> _attendance2 = new HashMap<>();
//                System.out.println(scd.getId() + " | " + student.getRollno());
//                System.out.println(attendanceEntity.totalPresentByScheduleId_StudentRollno(scd.getId() ,student.getRollno()));
                if (scd != null) {
                    for (attendance atd : attendanceEntity.totalPresentByScheduleId_StudentRollno(scd.getId() ,student.getRollno())) {
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
                }
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
        count = 0;
    }
    
}