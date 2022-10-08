/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.entities;

import static com.group2.project2.entities.BaseEntity.close;
import static com.group2.project2.entities.BaseEntity.conn;
import static com.group2.project2.entities.BaseEntity.open;
import static com.group2.project2.entities.BaseEntity.statement;
import com.group2.project2.model.attendance;
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
        int current_session = 0;
        
        open();
        
        String sql = "SELECT MAX(booking_id) AS 'Current Session' FROM `attendance` LEFT JOIN booking ON attendance.booking_id = booking.id WHERE schedule_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, schedule_id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                current_session = Integer.parseInt(resultSet.getString("Current Session"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(semesterEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        close();
        
        return current_session;
    }
}
