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
public class StatusEntity {
     public static void insert(Status stt){
        open();
 
        try{
            String sql = "insert into status(rollno, fullname) values(?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, stt.getId());
            statement.setString(2, stt.getDescribe());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(Status stt) {
        open();
        
        try {
            String sql = "update status set describe = ? where id = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, stt.getId());
            statement.setString(2, stt.getDescribe());

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
            Logger.getLogger(StatusEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        close();
    }

        public static Status findById(int id) {
        Status stt = null;
        
        open();
        
        String sql = "select * from status where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                stt = new Status(
                        resultSet.getInt("id"), 
                        resultSet.getString("describe"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return stt;
    }
        
    public static List<Status> findByDescribe(String s) {
        List<Status> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from status where describe like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+s+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Status stt = new Status(
                        resultSet.getInt("id"), 
                        resultSet.getString("describe"));
                dataList.add(stt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<Status> list() {
        List<Status> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from status";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Status stt = new Status(
                        resultSet.getInt("id"), 
                        resultSet.getString("describe"));
                dataList.add(stt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
