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
public class PermissionEntity {
        public static void insert(Permission per){
        open();
 
        try{
            String sql = "insert into permission(id, role) values (?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, per.getId());
            statement.setString(2, per.getRole());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(Permission per) {
        open();
        
        try {
            String sql = "update permission set role = ? where id = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, per.getId());
            statement.setString(2, per.getRole());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(int id) {
        open();
        
        String sql = "delete * from permission where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PermissionEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        close();
    }

        public static Permission findById(int id) {
        Permission per = null;
        
        open();
        
        String sql = "select * from permission where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                per = new Permission(
                        resultSet.getInt("id"), 
                        resultSet.getString("role")); 
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermissionEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return per;
    }
        
    public static List<Permission> findByRole(String s) {
        List<Permission> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from permission where role like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+s+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Permission per = new Permission(
                        resultSet.getInt("id"), 
                        resultSet.getString("role")); 
                dataList.add(per);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermissionEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<Permission> list() {
        List<Permission> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from permission";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Permission per = new Permission(
                        resultSet.getInt("id"), 
                        resultSet.getString("role")); 
                dataList.add(per);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermissionEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
