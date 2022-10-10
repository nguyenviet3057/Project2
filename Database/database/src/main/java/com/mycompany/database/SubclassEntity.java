package com.mycompany.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class SubclassEntity extends BaseEntity{
    public static void insert(Subclass subc){
        open();
 
        try{
            String sql = "insert into subclass(student_rollno, class_id) values (?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, subc.getStudent_rollno());
            statement.setInt(2, subc.getClass_id());

           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(Subclass subc) {
        open();
        
        try {
            String sql = "update subclass set class_id = ? where student_rollno = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setString(1, subc.getStudent_rollno());
            statement.setInt(2, subc.getClass_id());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(String student_rollno) {
        open();
        
        String sql = "delete * from students where student_rollno = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "student_rollno");
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SubclassEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        close();
    }

        public static Subclass findByStudentRollno(String student_rollno) {
        Subclass subc = null;
        
        open();
        
        String sql = "select * from subclass where student_rollno = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, student_rollno);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                subc = new Subclass(
                        resultSet.getString("student_rollno"), 
                        resultSet.getInt("class_id"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubclassEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return subc;
    }
        
    
    public static List<Subclass> list() {
        List<Subclass> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from subclass";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Subclass subc = new Subclass(
                        resultSet.getString("rollno"), 
                        resultSet.getInt("class_id"));
                dataList.add(subc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubclassEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
