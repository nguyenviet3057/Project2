/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.entities;

import com.group2.project2.model.classes;
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
public class classesEntity extends BaseEntity{
//    public static void insert(mark std){
//        open();
// 
//        try{
//            String sql = "insert into students(rollno, fullname, birthday, "
//                    + "phonenumber, address, Email, password, picture, "
//                    + "status_id, semester_id, class_id) " + "values "
//                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            statement = conn.prepareStatement(sql);
//            statement.setString(1, std.getRollno());
//            statement.setString(2, std.getFullname());
//            statement.setString(3, std.getBirthday());
//            statement.setString(4, std.getPhonenumber());
//            statement.setString(5, std.getAddress());
//            statement.setString(6, std.getEmail());
//            statement.setString(7, std.getPassword());
//            statement.setString(8, std.getPicture());
//            statement.setInt(9, std.getStatus_id());
//            statement.setInt(10, std.getSemester_id());
//            statement.setInt(11, std.getClass_id());
//           
//            statement.execute();
//        
//        }catch(SQLException e){
//            close();
//        }
//    }
//    
//    public static void update(students std) {
//        open();
//        
//        try {
//            String sql = "update students set fullname = ?, birthday = ?, "
//                    + "phonenumber = ?, address = ?, Email = ?, password = ?, "
//                    + "picture = ?, status_id = ?, semester_id = ?, "
//                    + "class_id = ? where rollno = ?";
//            
//            statement = conn.prepareStatement(sql);
//            statement.setString(1, std.getRollno());
//            statement.setString(2, std.getFullname());
//            statement.setString(3, std.getBirthday());
//            statement.setString(4, std.getPhonenumber());
//            statement.setString(5, std.getAddress());
//            statement.setString(6, std.getEmail());
//            statement.setString(7, std.getPassword());
//            statement.setString(8, std.getPicture());
//            statement.setInt(9, std.getStatus_id());
//            statement.setInt(10, std.getSemester_id());
//            statement.setInt(11, std.getClass_id());
//
//            statement.execute();
//        } catch(SQLException e) {}
//        
//        close();
//    }
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

        public static classes findById(int id) {
        classes cl = null;
        
        open();
        
        String sql = "select * from class where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                cl = new classes(
                        resultSet.getInt("id"),
                        resultSet.getString("name"), 
                        resultSet.getInt("n_std"), 
                        resultSet.getInt("staff_id")
                    );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(classesEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        
        close();
        
        return cl;
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
//                students std = new students(
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
//                dataList.add(std);
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
//                students std = new students(
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
//                dataList.add(std);
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
    
