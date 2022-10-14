/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.entities;

import static com.group2.project2.entities.BaseEntity.close;
import static com.group2.project2.entities.BaseEntity.conn;
import static com.group2.project2.entities.BaseEntity.open;
import static com.group2.project2.entities.BaseEntity.statement;
import com.group2.project2.model.StudentList;
import com.group2.project2.model.attendance;
import com.group2.project2.model.schedule;
import com.group2.project2.model.semester;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darkin
 */
public class attendanceEntity {
    
    public static attendance findByStudentRollno_BookingId(StudentList std, int booking_id) {
        attendance atd = null;
        
        open();
        
        String sql = "select * from attendance where student_rollno = ? and booking_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, std.getRollno());
            statement.setInt(2, booking_id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                atd = new attendance(
                        resultSet.getInt("id"),
                        resultSet.getInt("booking_id"), 
                        resultSet.getString("attendance1"), 
                        resultSet.getString("attendance2"),
                        resultSet.getString("note"),
                        resultSet.getString("student_rollno")
                    );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        
        close();
        
        return atd;
    }
    
    public static void updateAttendance1(StudentList std, int booking_id) {
        open();
        
        try {
            String sql = "update attendance set attendance1 = ? where booking_id = ? and student_rollno = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setString(1, std.getAttendance1().get(booking_id-1));
            statement.setInt(2, booking_id);
            statement.setString(3, std.getRollno());

            statement.execute();
        } catch(SQLException e) {}
        
//        System.out.println(std.getAttendance1().get(booking_id) + " | " + booking_id);
        close();
    }
    
    public static void updateAttendance2(StudentList std, int booking_id) {
        open();
        
        try {
            String sql = "update attendance set attendance2 = ? where booking_id = ? and student_rollno = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setString(1, std.getAttendance1().get(booking_id-1));
            statement.setInt(2, booking_id);
            statement.setString(3, std.getRollno());

            statement.execute();
        } catch(SQLException e) {}
        
//        System.out.println(std.getAttendance1().get(booking_id) + " | " + booking_id);
        close();
    }
    
    public static void insertAttendance1(StudentList std, int booking_id) {
//        System.out.println("Size: " + std.getAttendance1().size() + " | booking_id: " +booking_id);
        open();
        
        try {
            String sql = "insert into attendance(booking_id, attendance1, student_rollno) values (?, ?, ?)";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, booking_id);
            statement.setString(2, std.getAttendance1().get(booking_id-1));
            statement.setString(3, std.getRollno());

            statement.execute();
        } catch(SQLException e) {}
        
//        System.out.println(std.getAttendance1().get(booking_id) + " | " + booking_id);
        close();
    }
    
    public static void insert(StudentList std, int booking_id) {
//        System.out.println("Insert attendance with booking_id: " + booking_id);
        open();
        
        try {
            String sql = "insert into attendance(booking_id, student_rollno) values (?, ?)";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, booking_id);
            statement.setString(2, std.getRollno());

            statement.execute();
        } catch(SQLException e) {}
        
//        System.out.println(std.getAttendance1().get(booking_id) + " | " + booking_id);
        close();
    }
    
    public static List<attendance> totalPresentByScheduleId_StudentRollno(int schedule_id, String student_rollno) {
        List<attendance> dataList = new ArrayList<>();
        
        open();
        
        String sql = "SELECT * FROM `attendance` LEFT JOIN booking ON attendance.booking_id = booking.id WHERE schedule_id = ? AND student_rollno = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, schedule_id);
            statement.setString(2, student_rollno);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                attendance atd = new attendance(
                    resultSet.getInt("id"), 
                    resultSet.getInt("booking_id"), 
                    resultSet.getString("attendance1"), 
                    resultSet.getString("attendance2"),
                    resultSet.getString("note"),
                    resultSet.getString("student_rollno")
                );
                dataList.add(atd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(semesterEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        close();
        
        return dataList;
    }
    
    public static int currentByScheduleId(int schedule_id) {
//        System.out.println(schedule_id);
        int current_session = 0;
        
        open();
        
        String sql = "SELECT MAX(booking_id) AS 'Current Session' FROM `attendance` LEFT JOIN booking ON attendance.booking_id = booking.id WHERE schedule_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, schedule_id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
//                if (resultSet == null) break;
                current_session = Integer.parseInt(resultSet.getString("Current Session"));
//                System.out.println("Schedule ID: " + schedule_id + "\nCurrent Session: " + resultSet.getString("Current Session"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(semesterEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        close();
        
//        System.out.println("Check current_session: " + current_session);

        return current_session;
    }
}
