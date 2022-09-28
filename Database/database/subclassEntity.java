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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class subclassEntity extends BaseEntity{
    public static void insert(subclass subc){
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
    
    public static void update(subclass subc) {
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
            Logger.getLogger(subclassEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        close();
    }

        public static subclass findByStudentRollno(String student_rollno) {
        subclass subc = null;
        
        open();
        
        String sql = "select * from subclass where student_rollno = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, student_rollno);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                subc = new subclass(
                        resultSet.getString("student_rollno"), 
                        resultSet.getInt("class_id"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(subclassEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        
        close();
        
        return subc;
    }
        
    
    public static List<subclass> list() {
        List<subclass> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from subclass";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                subclass subc = new subclass(
                        resultSet.getString("rollno"), 
                        resultSet.getInt("class_id"));
                dataList.add(subc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(subclassEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
