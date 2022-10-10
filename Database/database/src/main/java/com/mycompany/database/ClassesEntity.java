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
public class ClassesEntity {
            public static void insert(Classes cla){
        open();
 
        try{
            String sql = "insert into classes(id, name, n_std, staff_id) values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, cla.getId());
            statement.setString(2, cla.getName());
            statement.setInt(3, cla.getN_std());
            statement.setInt(4, cla.getStaff_id());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(Classes cla) {
        open();
        
        try {
            String sql = "update classes set name = ?, n_std = ?, staff_id = ? "
                    + "where id = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, cla.getId());
            statement.setString(2, cla.getName());
            statement.setInt(3, cla.getN_std());
            statement.setInt(4, cla.getStaff_id());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(int id) {
        open();
        
        String sql = "delete * from classes where id= ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        close();
    }

        public static Classes findById(int id) {
        Classes cla = null;
        
        open();
        
        String sql = "select * from classes where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                cla = new Classes(
                        resultSet.getInt("id"), 
                        resultSet.getString("name"), 
                        resultSet.getInt("n_std"), 
                        resultSet.getInt("staff_id"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return cla;
    }
        
    public static List<Classes> findByName(String s) {
        List<Classes> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from classes where name like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+s+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Classes cla = new Classes(
                        resultSet.getInt("id"), 
                        resultSet.getString("name"), 
                        resultSet.getInt("n_std"), 
                        resultSet.getInt("staff_id"));
                dataList.add(cla);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<Classes> list() {
        List<Classes> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from classes";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Classes cla = new Classes(
                        resultSet.getInt("id"), 
                        resultSet.getString("fullname"), 
                        resultSet.getInt("n_std"), 
                        resultSet.getInt("staff_id")); 
                dataList.add(cla);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
