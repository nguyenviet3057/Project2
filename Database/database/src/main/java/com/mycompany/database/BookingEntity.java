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
public class BookingEntity {
        public static void insert(Booking book){
        open();
 
        try{
            String sql = "insert into booking(id, schedule_id, begin_time, "
                    + "end_time, note)  values (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, book.getId());
            statement.setInt(2, book.getSchedule_id());
            statement.setString(3, book.getBegin_time());
            statement.setString(4, book.getEnd_time());
            statement.setString(5, book.getNote());
           
            statement.execute();
        
        }catch(SQLException e){
            close();
        }
    }
    
    public static void update(Booking book) {
        open();
        
        try {
            String sql = "update booking set schedule_id = ?, begin_time = ?, "
                    + "end_time = ?, note = ? where rollno = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setInt(1, book.getId());
            statement.setInt(2, book.getSchedule_id());
            statement.setString(3, book.getBegin_time());
            statement.setString(4, book.getEnd_time());
            statement.setString(5, book.getNote());

            statement.execute();
        } catch(SQLException e) {}
        
        close();
    }
    
    public static void delete(int id) {
        open();
        
        String sql = "delete * from booking where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BookingEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        close();
    }

        public static Booking findById(int id) {
        Booking book = null;
        
        open();
        
        String sql = "select * from booking where int = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                book = new Booking(
                        resultSet.getInt("id"), 
                        resultSet.getInt("schedule_id"), 
                        resultSet.getString("begin_time"), 
                        resultSet.getString("end_time"), 
                        resultSet.getString("note"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        
        
        close();
        
        return book;
    }
        
    
    public static List<Booking> list() {
        List<Booking> dataList = new ArrayList<>();
        
        open();
        
        String sql = "select * from booking";
        try {
            statement = conn.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Booking book = new Booking(
                        resultSet.getInt("id"), 
                        resultSet.getInt("schedule_id"), 
                        resultSet.getString("begin_time"), 
                        resultSet.getString("end_time"), 
                        resultSet.getString("note"));
                dataList.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        close();
        
        return dataList;
    }
}
