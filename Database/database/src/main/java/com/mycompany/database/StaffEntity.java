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
public class StaffEntity extends BaseEntity{
        public static void insert(Staff sta){
        open();
 
        try{
            String sql = "insert into staff(id, name, permission_id, "
                    + "birthday, address, phone_number, email, pic, salary) " + "values "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, sta.getId());
            statement.setString(2, sta.getName());
            statement.setInt(3, sta.getPermission_id());
            statement.setString(4, sta.getBirthday());
            statement.setString(5, sta.getAddress());
            statement.setString(6, sta.getPhone_number());
            statement.setString(7, sta.getEmail());
            statement.setString(8, sta.getPic());
            statement.setFloat(9, sta.getSalary());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(Staff sta) {
        open();
        
        try {
            String sql = "update staff set name = ?, permission_id = ?, irthday = ?, address = ?, phone_number = ?, " +
                    "email = ?, pic = ?,salary = ? where id = ?";
            
            statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setInt(1, sta.getId());
            statement.setString(2, sta.getName());
            statement.setInt(3, sta.getPermission_id());
            statement.setString(4, sta.getBirthday());
            statement.setString(5, sta.getAddress());
            statement.setString(6, sta.getPhone_number());
            statement.setString(7, sta.getEmail());
            statement.setString(8, sta.getPic());
            statement.setFloat(9, sta.getSalary());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(int id) {
        open();
        
        String sql = "delete * from staff where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StaffEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        close();
    }

        public static Staff findById(int id) {
        Staff sta = null;
        
        open();
        
        String sql = "select * from staff where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                sta = new Staff(
                        resultSet.getInt("id"), 
                        resultSet.getString("name"),
                        resultSet.getInt("permission_id"),
                        resultSet.getString("birthday"),
                        resultSet.getString("address"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("pic"),
                        resultSet.getFloat("salary"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return sta;
    }
        
    public static List<Staff> findByName(String s) {
        List<Staff> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from staff where fullname like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+s+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Staff sta = new Staff(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("permission_id"),
                        resultSet.getString("birthday"),
                        resultSet.getString("address"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("pic"),
                        resultSet.getFloat("salary"));
                dataList.add(sta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<Staff> list() {
        List<Staff> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from staff";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Staff sta = new Staff(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("permission_id"),
                        resultSet.getString("birthday"),
                        resultSet.getString("address"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("pic"),
                        resultSet.getFloat("salary"));
                dataList.add(sta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
