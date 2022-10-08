/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.entities;

import static com.group2.project2.entities.BaseEntity.close;
import static com.group2.project2.entities.BaseEntity.conn;
import static com.group2.project2.entities.BaseEntity.open;
import static com.group2.project2.entities.BaseEntity.statement;
import com.group2.project2.model.booking;
import com.group2.project2.model.students;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darkin
 */
public class bookingEntity {
    public static void insert(booking bk){
        open();
 
        try{
            String sql = "insert into booking(schedule_id, begin_time, end_time, note) values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, bk.getSchedule_id());
            statement.setTimestamp(2, bk.getBegin_time());
            statement.setTimestamp(3, bk.getEnd_time());
            statement.setString(4, bk.getNote());
            
//            System.out.println("Inserted Data");
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    public static List<booking> findByScheduleId(int schedule_id) {
        List<booking> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from booking where schedule_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, schedule_id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                booking b = new booking(
                        resultSet.getInt("id"), 
                        resultSet.getInt("schedule_id"), 
                        resultSet.getTimestamp("begin_time"), 
                        resultSet.getTimestamp("end_time")
                );
                dataList.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentsEntity.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        close();
        
        return dataList;
    }
}
