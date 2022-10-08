/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.entities;

import com.group2.project2.model.mark;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class markEntity extends BaseEntity{
    public static void insert(mark m){
        open();
 
        try{
            String sql = "insert into mark(subject_id , student_rollno , mark_t1, mark_p1, create_at1, mark_t2, mark_p2, create_at2, values (?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, m.getSubject_id());
            statement.setString(2, m.getStudent_rollno());
            statement.setInt(3, m.getMark_t1());
            statement.setInt(4, m.getMark_p1());
            statement.setDate(5, m.getCreate_at1());
            statement.setInt(6, m.getMark_t2());
            statement.setInt(7, m.getMark_p2());
            statement.setDate(8, m.getCreate_at2());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
//    
    public static void update(mark m) {
        open();
        
        try {
            String sql = "update mark set subject_id = ?, mark_t1 = ?, mark_p1 = ?, create_at1 = ?, mark_t2 = ?, mark_p2 = ?, create_at2 = ? where student_rollno = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, m.getSubject_id());
            statement.setInt(2, m.getMark_t1());
            statement.setInt(3, m.getMark_p1());
            statement.setDate(4, m.getCreate_at1());
            statement.setInt(5, m.getMark_t2());
            statement.setInt(6, m.getMark_p2());
            statement.setDate(7, m.getCreate_at2());
            statement.setString(8, m.getStudent_rollno());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
//    
//    public static void delete(String rollno) {
//        open();
//        
//        String sql = "delete * from students where rollno = ?";
//        try {
//            statement = conn.prepareStatement(sql);
//            statement.setString(1, "rollno");
//            
//            statement.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(markEntity.class.getName()).log(Level.SEVERE, 
//                    null, ex);
//        }
//        
//        close();
//    }

        public static List<mark> findByRollno(String rollno) {
        List<mark> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from mark where student_rollno = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, rollno);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                mark m = new mark(
                    resultSet.getInt("id"), 
                    resultSet.getInt("subject_id"), 
                    resultSet.getString("student_rollno"), 
                    resultSet.getInt("mark_t1"), 
                    resultSet.getInt("mark_p1"),
                    resultSet.getDate("create_at1"),
                    resultSet.getInt("mark_t2"), 
                    resultSet.getInt("mark_p2"),
                    resultSet.getDate("create_at2")
                );
                dataList.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(markEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
        
//    public static List<students> findByName(String s) {
//        List<students> dataList = new ArrayList<>();
//        
//        open();
//        
//        String sql = "select * from students where fullname like ?";
//        try {
//            statement = conn.prepareStatement(sql);
//            statement.setString(1, "%"+s+"%");
//            
//            ResultSet resultSet = statement.executeQuery();
//            
//            while(resultSet.next()) {
//                students m = new students(
//                        resultSet.getString("rollno"), 
//                        resultSet.getString("fullname"), 
//                        resultSet.getString("birthday"), 
//                        resultSet.getString("phonenumber"), 
//                        resultSet.getString("address"),
//                        resultSet.getString("Email"),
//                        resultSet.getString("password"),
//                        resultSet.getString("picture"),
//                        resultSet.getInt("status_id"),
//                        resultSet.getInt("semester_id"),
//                        resultSet.getInt("class_id"));
//                dataList.add(m);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(markEntity.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        close();
//        
//        return dataList;
//    }
//    
//    public static List<students> list() {
//        List<students> dataList = new ArrayList<>();
//        
//        open();
//        
//        String sql = "select * from students";
//        try {
//            statement = conn.prepareStatement(sql);
//            
//            ResultSet resultSet = statement.executeQuery();
//            
//            while(resultSet.next()) {
//                students m = new students(
//                        resultSet.getString("rollno"), 
//                        resultSet.getString("fullname"), 
//                        resultSet.getString("birthday"), 
//                        resultSet.getString("phonenumber"), 
//                        resultSet.getString("address"),
//                        resultSet.getString("Email"),
//                        resultSet.getString("password"),
//                        resultSet.getString("picture"),
//                        resultSet.getInt("status_id"),
//                        resultSet.getInt("semester_id"),
//                        resultSet.getInt("class_id"));
//                dataList.add(m);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(markEntity.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        close();
//        
//        return dataList;
//    }
}
    
