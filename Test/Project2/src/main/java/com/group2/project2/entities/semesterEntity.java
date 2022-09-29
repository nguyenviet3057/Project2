/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.entities;

import com.group2.project2.model.semester;
import static com.group2.project2.entities.BaseEntity.close;
import static com.group2.project2.entities.BaseEntity.conn;
import static com.group2.project2.entities.BaseEntity.open;
import static com.group2.project2.entities.BaseEntity.statement;
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
public class semesterEntity {
            public static void insert(semester sem){
        open();
 
        try{
            String sql = "insert into semester(id, semester_id, subject_no, "
                    + "start_year, values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, sem.getId());
            statement.setInt(2, sem.getSemester_id());
            statement.setInt(3, sem.getSubject_no());
            statement.setString(4, sem.getStart_year());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(semester sem) {
        open();
        
        try {
            String sql = "update semester set semester_id = ?, subject_no = ?, "
                    + "start_year = ? where id = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, sem.getId());
            statement.setInt(2, sem.getSemester_id());
            statement.setInt(3, sem.getSubject_no());
            statement.setString(4, sem.getStart_year());
            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(int id) {
        open();
        
        String sql = "delete * from semester where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(semesterEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        close();
    }

        public static semester findById(int id) {
        semester sem = null;
        
        open();
        
        String sql = "select * from semester where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                sem = new semester(
                        resultSet.getInt("id"), 
                        resultSet.getInt("semester_no"), 
                        resultSet.getInt("subject_id"), 
                        resultSet.getString("start_year")); 
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(semesterEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        
        close();
        
        return sem;
    }
        
    public static List<semester> findByStartYear(String s) {
        List<semester> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from semester where start_year like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+s+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                semester sem = new semester(
                        resultSet.getInt("id"), 
                        resultSet.getInt("semester_id"), 
                        resultSet.getInt("subject_no"), 
                        resultSet.getString("start_year"));
                dataList.add(sem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(semesterEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<semester> list() {
        List<semester> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from semester";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                semester sem = new semester(
                        resultSet.getInt("id"), 
                        resultSet.getInt("semester_id"), 
                        resultSet.getInt("subject_no"), 
                        resultSet.getString("start_year"));
                dataList.add(sem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(semesterEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
