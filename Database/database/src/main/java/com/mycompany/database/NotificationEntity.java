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
public class NotificationEntity {
            public static void insert(Notification noti){
        open();
 
        try{
            String sql = "insert into notification(id, staff_id, content, "
                    + "created_at, updated_at values (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, noti.getId());
            statement.setInt(2, noti.getStaff_id());
            statement.setString(3, noti.getContent());
            statement.setString(4, noti.getCreated_at());
            statement.setString(5, noti.getUpdated_at());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(Notification noti) {
        open();
        
        try {
            String sql = "update notification set staff_id = ?, content = ?, "
                    + "created_at = ?, updated_at=? where id = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, noti.getId());
            statement.setInt(2, noti.getStaff_id());
            statement.setString(3, noti.getContent());
            statement.setString(4, noti.getCreated_at());
            statement.setString(5, noti.getUpdated_at());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(int id) {
        open();
        
        String sql = "delete * from notification where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(NotificationEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        close();
    }

        public static Notification findById(int id) {
        Notification noti = null;
        
        open();
        
        String sql = "select * from notification where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                noti = new Notification(
                        resultSet.getInt("id"), 
                        resultSet.getInt("staff_id"), 
                        resultSet.getString("content"), 
                        resultSet.getString("created_at"), 
                        resultSet.getString("updated_at"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return noti;
    }
        
    public static List<Notification> findByContent(String s) {
        List<Notification> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from notification where content like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+s+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Notification noti = new Notification(
                        resultSet.getInt("id"), 
                        resultSet.getInt("staff_id"), 
                        resultSet.getString("content"), 
                        resultSet.getString("created_at"), 
                        resultSet.getString("updated_at"));

                dataList.add(noti);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<Notification> list() {
        List<Notification> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from notification";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Notification noti = new Notification(
                        resultSet.getInt("id"), 
                        resultSet.getInt("staff_id"), 
                        resultSet.getString("content"), 
                        resultSet.getString("created_at"), 
                        resultSet.getString("updated_at"));
                dataList.add(noti);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
