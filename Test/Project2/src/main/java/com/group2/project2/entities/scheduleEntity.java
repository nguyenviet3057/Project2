/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.entities;

import com.group2.project2.model.staff;
import static com.group2.project2.entities.BaseEntity.close;
import static com.group2.project2.entities.BaseEntity.conn;
import static com.group2.project2.entities.BaseEntity.open;
import static com.group2.project2.entities.BaseEntity.statement;
import com.group2.project2.model.schedule;
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
public class scheduleEntity {
    public static void insert(schedule scd){
        open();
 
        try{
            String sql = "insert into schedule(subject_id, class_id, start_date, end_date values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, scd.getSubject_id());
            statement.setInt(2, scd.getClass_id());
            statement.setDate(3, scd.getStart_date());
            statement.setDate(4, scd.getEnd_date());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(schedule scd) {
        open();
        
        try {
            String sql = "update schedule set subject_id = ?, class_id = ?, start_date = ?, end_date = ? where id = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, scd.getSubject_id());
            statement.setInt(2, scd.getClass_id());
            statement.setDate(3, scd.getStart_date());
            statement.setDate(4, scd.getEnd_date());
            statement.setInt(5, scd.getId());

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
            Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        close();
    }

    public static schedule findById(int id) {
        schedule scd = null;
        
        open();
        
        String sql = "select * from schedule where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                scd = new schedule(
                        resultSet.getInt("id"),
                        resultSet.getInt("subject_id"), 
                        resultSet.getInt("class_id"), 
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date")
                    );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        
        close();
        
        return scd;
    }
        
    public static schedule findBySubject_Class(int subject_id, int class_id) {
        schedule scd = null;
        
        open();
        
        String sql = "select * from schedule where subject_id = ? and class_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, subject_id);
            statement.setInt(2, class_id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                scd = new schedule(
                        resultSet.getInt("id"),
                        resultSet.getInt("subject_id"), 
                        resultSet.getInt("class_id"), 
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date")
                    );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        
        close();
        
        return scd;
    }
        
//    public static List<staff> findByName(String s) {
//        List<staff> dataList = new ArrayList<>();
//        
//        open();
//        
//        String sql = "select * from staff where fullname like ?";
//        try {
//            statement = conn.prepareStatement(sql);
//            statement.setString(1, "%"+s+"%");
//            
//            ResultSet resultSet = statement.executeQuery();
//            
//            while(resultSet.next()) {
//                staff sta = new staff(
//                        resultSet.getInt("id"), 
//                        resultSet.getString("fullname"), 
//                        resultSet.getString("birthday"), 
//                        resultSet.getString("phonenumber"), 
//                        resultSet.getString("address"),
//                        resultSet.getString("Email"),
//                        resultSet.getString("password"),
//                        resultSet.getString("picture"),
//                        resultSet.getFloat("salary"),
//                        resultSet.getInt("permission_id"));
//                dataList.add(sta);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE,null, ex);
//        }
//        
//        
//        close();
//        
//        return dataList;
//    }
//    
    public static List<schedule> list() {
        List<schedule> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from schedule";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                schedule scd = new schedule(
                        resultSet.getInt("id"),
                        resultSet.getInt("subject_id"), 
                        resultSet.getInt("class_id"), 
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date")
                    );
                dataList.add(scd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        close();
        
        return dataList;
    }
}
