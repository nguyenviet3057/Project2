/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

import static com.mycompany.database.BaseEntity.close;
import static com.mycompany.database.BaseEntity.conn;
import static com.mycompany.database.BaseEntity.open;
import static com.mycompany.database.BaseEntity.statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ScheduleEntity {
            public static void insert(Schedule sch){
        open();
 
        try{
            String sql = "insert into schedule(id, staff_id, subject_id, "
                    + "class_id, start_date, end_date) values "
                    + "(?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, sch.getId());
            statement.setInt(2, sch.getStaff_id());
            statement.setInt(3, sch.getSubject_id());
            statement.setInt(4, sch.getClass_id());
            statement.setString(5, sch.getStart_date());
            statement.setString(6, sch.getEnd_date());

           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(Schedule sch) {
        open();
        
        try {
            String sql = "update schedule set staff_id = ?, subject_id = ?, "
                    + "class_id = ?, start_date = ?, end_date = ? where id = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, sch.getId());
            statement.setInt(2, sch.getStaff_id());
            statement.setInt(3, sch.getSubject_id());
            statement.setInt(4, sch.getClass_id());
            statement.setString(5, sch.getStart_date());
            statement.setString(6, sch.getEnd_date());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(int id) {
        open();
        
        String sql = "delete * from schedule where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        close();
    }

        public static Schedule findById(int id) {
        Schedule sch = null;
        
        open();
        
        String sql = "select * from schedule where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                sch = new Schedule(
                        resultSet.getInt("id"), 
                        resultSet.getInt("staff_id"), 
                        resultSet.getInt("subject_id"), 
                        resultSet.getInt("class_id"), 
                        resultSet.getString("start_date"),
                        resultSet.getString("end_date"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return sch;
    }
        
 
    public static List<Schedule> list() {
        List<Schedule> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from schedule";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Schedule sch = new Schedule(
                        resultSet.getInt("id"), 
                        resultSet.getInt("staff_id"), 
                        resultSet.getInt("subject_id"), 
                        resultSet.getInt("class_id"), 
                        resultSet.getString("start_date"),
                        resultSet.getString("end_date"));
                dataList.add(sch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
