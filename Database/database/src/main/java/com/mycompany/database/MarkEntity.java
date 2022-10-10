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
public class MarkEntity {
    public static void insert(Mark mar){
        open();
 
        try{
            String sql = "insert into mark(id, subject_id, student_rollno "
                    + "mark_t1, mark_p1, created_at1, mark_t2, mark_p2,  "
                    + "created_at2) " + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, mar.getId());
            statement.setInt(2, mar.getSubject_id());
            statement.setString(3, mar.getStudent_rollno());
            statement.setFloat(4, mar.getMark_t1());
            statement.setFloat(5, mar.getMark_p1());
            statement.setString(6, mar.getCreated_at1());
            statement.setFloat(7, mar.getMark_t2());
            statement.setFloat(8, mar.getMark_p2());
            statement.setString(9, mar.getCreated_at2());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(Mark mar) {
        open();
        
        try {
            String sql = "update mark set subject_id = ?, student_rollno = ?, "
                    + "mark_t1 = ?, mark_p1 = ?, created_at1 = ?, "
                    + "mark_t2 = ?, mark_p2 = ?, created_at2 = ?,  where "
                    + "rollno = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, mar.getId());
            statement.setInt(2, mar.getSubject_id());
            statement.setString(3, mar.getStudent_rollno());
            statement.setFloat(4, mar.getMark_t1());
            statement.setFloat(5, mar.getMark_p1());
            statement.setString(6, mar.getCreated_at1());
            statement.setFloat(7, mar.getMark_t2());
            statement.setFloat(8, mar.getMark_p2());
            statement.setString(9, mar.getCreated_at2());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(String rollno) {
        open();
        
        String sql = "delete * from mark where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "rollno");
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MarkEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        close();
    }

        public static Mark findBy(int id) {
        Mark mar = null;
        
        open();
        
        String sql = "select * from mark where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                mar = new Mark(
                        resultSet.getInt("id"), 
                        resultSet.getInt("subject_id"), 
                        resultSet.getString("student_rollno"), 
                        resultSet.getFloat("mark_t1"), 
                        resultSet.getFloat("mark_p1"),
                        resultSet.getString("created_at1"),
                        resultSet.getFloat("mark_t2"),
                        resultSet.getFloat("mark_p2"),
                        resultSet.getString("created_at2"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarkEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return mar;
    }
        
    
    
    public static List<Mark> list() {
        List<Mark> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from mark";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Mark mar = new Mark(
                        resultSet.getInt("id"), 
                        resultSet.getInt("subject_id"), 
                        resultSet.getString("student_rollno"), 
                        resultSet.getFloat("mark_t1"), 
                        resultSet.getFloat("mark_p1"),
                        resultSet.getString("created_at1"),
                        resultSet.getFloat("mark_t2"),
                        resultSet.getFloat("mark_p2"),
                        resultSet.getString("created_at2"));
                dataList.add(mar);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarkEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
