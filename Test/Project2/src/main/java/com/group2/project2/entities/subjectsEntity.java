/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.entities;

import com.group2.project2.model.subjects;
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
public class subjectsEntity extends BaseEntity{
     public static void insert(subjects subj){
        open();
 
        try{
            String sql = "insert into subject (id, name, session, staff_id) values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, subj.getId());
            statement.setString(2, subj.getName());
            statement.setInt(3, subj.getSessions());
            statement.setInt(4, subj.getStaff_id());
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(subjects subj) {
        open();
        
        try {
            String sql = "update subject set name = ?, session = ?, "
                    + "staff_id = ? where rollno = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, subj.getId());
            statement.setString(2, subj.getName());
            statement.setInt(3, subj.getSessions());
            statement.setInt(4, subj.getStaff_id());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(int id) {
        open();
        
        String sql = "delete * from subject where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(subjectsEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        close();
    }

        public static subjects findByID(int id) {
        subjects subj = null;
        
        open();
        
        String sql = "select * from subject where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                subj = new subjects(
                        resultSet.getInt("id"), 
                        resultSet.getString("name"), 
                        resultSet.getInt("session"), 
                        resultSet.getInt("staff_id")); 
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(subjectsEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        
        close();
        
        return subj;
    }
        
    public static List<subjects> findBySemesterId(int semester_id) {
        List<subjects> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select subject.id, subject.name, subject.session, subject.staff_id from subject right join semester on subject.id = semester.subject_id where semester_no = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, semester_id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                subjects subj = new subjects(
                        resultSet.getInt("id"), 
                        resultSet.getString("name"), 
                        resultSet.getInt("session"), 
                        resultSet.getInt("staff_id"));
                dataList.add(subj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(subjectsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<subjects> findByStaffId(int staff_id) {
        List<subjects> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from subject where staff_id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, staff_id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                subjects subj = new subjects(
                        resultSet.getInt("id"), 
                        resultSet.getString("name"), 
                        resultSet.getInt("session"), 
                        resultSet.getInt("staff_id"));
                dataList.add(subj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(subjectsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        close();
        
        return dataList;
    }
    
    public static List<subjects> list() {
        List<subjects> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from subject";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                subjects subj = new subjects(
                        resultSet.getInt("id"), 
                        resultSet.getString("name"), 
                        resultSet.getInt("session"),
                        resultSet.getInt("staff_id"));
                dataList.add(subj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(subjectsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
