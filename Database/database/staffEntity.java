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
public class staffEntity extends BaseEntity{
        public static void insert(staff sta){
        open();
 
        try{
            String sql = "insert into staff(id, fullname, birthday, "
                    + "phonenumber, address, email, password, picture, "
                    + "salary, permission_id) " + "values "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, sta.getId());
            statement.setString(2, sta.getFullname());
            statement.setString(3, sta.getBirthday());
            statement.setString(4, sta.getPhonenumber());
            statement.setString(5, sta.getAddress());
            statement.setString(6, sta.getEmail());
            statement.setString(7, sta.getPassword());
            statement.setString(8, sta.getPicture());
            statement.setFloat(9, sta.getSalary());
            statement.setInt(10, sta.getPermission_id());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(staff sta) {
        open();
        
        try {
            String sql = "update staff set fullname = ?, birthday = ?, "
                    + "phonenumber = ?, address = ?, Email = ?, password = ?, "
                    + "picture = ?,salary = ?, permission_id = ? where id = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, sta.getId());
            statement.setString(2, sta.getFullname());
            statement.setString(3, sta.getBirthday());
            statement.setString(4, sta.getPhonenumber());
            statement.setString(5, sta.getAddress());
            statement.setString(6, sta.getEmail());
            statement.setString(7, sta.getPassword());
            statement.setString(8, sta.getPicture());
            statement.setFloat(9, sta.getSalary());
            statement.setInt(10, sta.getPermission_id());

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
            Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        close();
    }

        public static staff findById(int id) {
        staff sta = null;
        
        open();
        
        String sql = "select * from staff where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                sta = new staff(
                        resultSet.getInt("id"), 
                        resultSet.getString("fullname"), 
                        resultSet.getString("birthday"), 
                        resultSet.getString("phonenumber"), 
                        resultSet.getString("address"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("picture"),
                        resultSet.getFloat("salary"),
                        resultSet.getInt("permission_id"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        
        close();
        
        return sta;
    }
        
    public static List<staff> findByName(String s) {
        List<staff> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from staff where fullname like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%"+s+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                staff sta = new staff(
                        resultSet.getInt("id"), 
                        resultSet.getString("fullname"), 
                        resultSet.getString("birthday"), 
                        resultSet.getString("phonenumber"), 
                        resultSet.getString("address"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("picture"),
                        resultSet.getFloat("salary"),
                        resultSet.getInt("permission_id"));
                dataList.add(sta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
    
    public static List<staff> list() {
        List<staff> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from staff";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                staff sta = new staff(
                        resultSet.getInt("id"), 
                        resultSet.getString("fullname"), 
                        resultSet.getString("birthday"), 
                        resultSet.getString("phonenumber"), 
                        resultSet.getString("address"),
                        resultSet.getString("Email"),
                        resultSet.getString("password"),
                        resultSet.getString("picture"),
                        resultSet.getFloat("salary"),
                        resultSet.getInt("class_id"));
                dataList.add(sta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
