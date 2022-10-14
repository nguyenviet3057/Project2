/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.entities;

import com.group2.project2.model.students;
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
public class studentsEntity extends BaseEntity{
    public static void insert(students std){
        open();
 
        try{
            String sql = "insert into students(rollno, fullname, birth, "
                    + "phone, address, email, password, pic, "
                    + "status_id, semester_id, class_id, gender) " + "values "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, std.getRollno());
            statement.setString(2, std.getFullname());
            statement.setDate(3, std.getBirthday());
            statement.setString(4, std.getPhonenumber());
            statement.setString(5, std.getAddress());
            statement.setString(6, std.getEmail());
            statement.setString(7, std.getPassword());
            statement.setString(8, std.getPicture());
            statement.setInt(9, std.getStatus_id());
            statement.setInt(10, std.getSemester_id());
            statement.setInt(11, std.getClass_id());
            statement.setString(12, std.getGender());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(students std) {
        System.out.println(std.getRollno());
        open();
        
        try {
            String sql = "update students set fullname = ?, birth = ?, "
                    + "phone = ?, address = ?, email = ?, password = ?, "
                    + "pic = ?, status_id = ?, semester_id = ?, "
                    + "class_id = ?, gender = ? where rollno = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setString(1, std.getFullname());
            statement.setDate(2, std.getBirthday());
            statement.setString(3, std.getPhonenumber());
            statement.setString(4, std.getAddress());
            statement.setString(5, std.getEmail());
            statement.setString(6, std.getPassword());
            statement.setString(7, std.getPicture());
            statement.setInt(8, std.getStatus_id());
            statement.setInt(9, std.getSemester_id());
            statement.setInt(10, std.getClass_id());
            statement.setString(11, std.getGender());
            statement.setString(12, std.getRollno());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(String rollno) {
        open();
        
        String sql = "delete * from students where rollno = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "rollno");
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(studentsEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        close();
    }

    public static students findByRollno(String rollno) {
        students std = null;
        
        open();
        
        String sql = "select * from students where rollno = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, rollno);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                std = new students(
                        resultSet.getString("rollno"), 
                        resultSet.getString("fullname"), 
                        resultSet.getDate("birth"), 
                        resultSet.getString("phone"), 
                        resultSet.getString("address"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("pic"),
                        resultSet.getInt("status_id"),
                        resultSet.getInt("semester_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getString("gender")
                );
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentsEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        
        close();
        
        return std;
    }
        
    public static List<students> findByName(String s) {
        List<students> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from students where fullname like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+s+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                students std = new students(
                        resultSet.getString("rollno"), 
                        resultSet.getString("fullname"), 
                        resultSet.getDate("birth"), 
                        resultSet.getString("phonenumber"), 
                        resultSet.getString("address"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("pic"),
                        resultSet.getInt("status_id"),
                        resultSet.getInt("semester_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getString("gender")
                );
                dataList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
        
    public static List<students> findByClassId(int id) {
        List<students> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from students where class_id = ? ";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                students std = new students(
                        resultSet.getString("rollno"), 
                        resultSet.getString("fullname"), 
                        resultSet.getDate("birth"), 
                        resultSet.getString("phone"), 
                        resultSet.getString("address"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("pic"),
                        resultSet.getInt("status_id"),
                        resultSet.getInt("semester_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getString("gender")
                );
                dataList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<students> list() {
        List<students> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from students";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                students std = new students(
                        resultSet.getString("rollno"), 
                        resultSet.getString("fullname"), 
                        resultSet.getDate("birth"), 
                        resultSet.getString("phonenumber"), 
                        resultSet.getString("address"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("picture"),
                        resultSet.getInt("status_id"),
                        resultSet.getInt("semester_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getString("gender")
                );
                dataList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
    
