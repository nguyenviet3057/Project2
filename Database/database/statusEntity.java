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
public class statusEntity {
     public static void insert(status stt){
        open();
 
        try{
            String sql = "insert into status(rollno, fullname) values(?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, stt.getId());
            statement.setString(2, stt.getDesc());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(status stt) {
        open();
        
        try {
            String sql = "update status set desc = ? where id = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, stt.getId());
            statement.setString(2, stt.getDesc());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(int id) {
        open();
        
        String sql = "delete * from status where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(statusEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        close();
    }

        public static status findById(int id) {
        status stt = null;
        
        open();
        
        String sql = "select * from status where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                stt = new status(
                        resultSet.getInt("id"), 
                        resultSet.getString("desc"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(statusEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        
        close();
        
        return stt;
    }
        
    public static List<status> findByDesc(String s) {
        List<status> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from status where desc like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+s+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                status stt = new status(
                        resultSet.getInt("id"), 
                        resultSet.getString("desc"));
                dataList.add(stt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(statusEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<status> list() {
        List<status> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from status";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                status stt = new status(
                        resultSet.getInt("id"), 
                        resultSet.getString("desc")); 
                dataList.add(stt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(statusEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
