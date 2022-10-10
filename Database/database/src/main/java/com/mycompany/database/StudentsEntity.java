/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

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
public class StudentsEntity extends BaseEntity{
    public static void insert(Students std){
        open();
 
        try{
            String sql = "insert into students(rollno, fullname, birthday, "
                    + "phone_number, address, email, password, picture, "
                    + "semester_id, class_id, status_id, gender) " + "values "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, std.getRollno());
            statement.setString(2, std.getFullname());
            statement.setString(3, std.getBirthday());
            statement.setString(4, std.getPhone_number());
            statement.setString(5, std.getAddress());
            statement.setString(6, std.getEmail());
            statement.setString(7, std.getPassword());
            statement.setString(8, std.getPicture());
            statement.setInt(9, std.getSemester_id());
            statement.setInt(10, std.getClass_id());
            statement.setInt(11, std.getStatus_id());
            statement.setString(12, std.getGender());

           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(Students std) {
        open();
        
        try {
            String sql = "update students set fullname = ?, birthday = ?, phone_number = ?, address = ?, email = ?, " +
                "password = ?,picture = ?,  semester_id = ?,class_id = ?, status_id = ?, gender = ? where rollno = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setString(1, std.getRollno());
            statement.setString(2, std.getFullname());
            statement.setString(3, std.getBirthday());
            statement.setString(4, std.getPhone_number());
            statement.setString(5, std.getAddress());
            statement.setString(6, std.getEmail());
            statement.setString(7, std.getPassword());
            statement.setString(8, std.getPicture());
            statement.setInt(9, std.getSemester_id());
            statement.setInt(10, std.getClass_id());
            statement.setInt(11, std.getStatus_id());
            statement.setString(12, std.getGender());


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
            Logger.getLogger(StudentsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        close();
    }

        public static Students findByRollno(String rollno) {
        Students std = null;
        
        open();
        
        String sql = "select * from students where rollno = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, rollno);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                std = new Students(
                        resultSet.getString("rollno"), 
                        resultSet.getString("fullname"), 
                        resultSet.getString("birthday"), 
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("picture"),
                        resultSet.getInt("semester_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getInt("status_id"),
                        resultSet.getString("gender"));

                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return std;
    }
        
    public static List<Students> findByName(String s) {
        List<Students> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from students where fullname like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+s+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Students std = new Students(
                        resultSet.getString("rollno"), 
                        resultSet.getString("fullname"), 
                        resultSet.getString("birthday"), 
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("picture"),
                        resultSet.getInt("semester_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getInt("status_id"),
                        resultSet.getString("gender"));

                dataList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<Students> list() {
        List<Students> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from students";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Students std = new Students(
                        resultSet.getString("rollno"), 
                        resultSet.getString("fullname"), 
                        resultSet.getString("birthday"), 
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("picture"),
                        resultSet.getInt("semester_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getInt("status_id"),
                        resultSet.getString("gender"));

                dataList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
    
