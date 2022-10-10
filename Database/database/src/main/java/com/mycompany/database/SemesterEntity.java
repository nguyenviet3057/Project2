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
public class SemesterEntity {
            public static void insert(Semester sem){
        open();
 
        try{
            String sql = "insert into semester(id, semester_no, subject_id, "
                    + "start_year, values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, sem.getId());
            statement.setInt(2, sem.getSemester_no());
            statement.setInt(3, sem.getSubject_id());
            statement.setString(4, sem.getStart_year());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(Semester sem) {
        open();
        
        try {
            String sql = "update semester set semester_no = ?, subject_id = ?, "
                    + "start_year = ? where id = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, sem.getId());
            statement.setInt(2, sem.getSemester_no());
            statement.setInt(3, sem.getSubject_id());
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
            Logger.getLogger(SemesterEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        close();
    }

        public static Semester findById(int id) {
        Semester sem = null;
        
        open();
        
        String sql = "select * from semester where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                sem = new Semester(
                        resultSet.getInt("id"), 
                        resultSet.getInt("semester_no"),
                        resultSet.getInt("subject_id"),
                        resultSet.getString("start_year")); 
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return sem;
    }
        
    public static List<Semester> findByStartYear(String s) {
        List<Semester> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from semester where start_year like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+s+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Semester sem = new Semester(
                        resultSet.getInt("id"), 
                        resultSet.getInt("semester_no"),
                        resultSet.getInt("subject_id"),
                        resultSet.getString("start_year"));
                dataList.add(sem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<Semester> list() {
        List<Semester> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from semester";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Semester sem = new Semester(
                        resultSet.getInt("id"), 
                        resultSet.getInt("semester_no"),
                        resultSet.getInt("subject_id"),
                        resultSet.getString("start_year"));
                dataList.add(sem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
