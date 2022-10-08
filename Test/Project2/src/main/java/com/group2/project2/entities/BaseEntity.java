/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.entities;

import com.group2.project2.model.booking;
import com.group2.project2.model.schedule;
import com.group2.project2.model.students;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BaseEntity{
    static final String DATABASE = "eproject";
    static final String USERNAME = "root";
    static final String PWD = "";
    static Connection conn = null;
    static PreparedStatement statement = null;
    
    protected static void open(){
        //Mo ket noi toi database
        try{
//            System.out.println("Try connecting to DB");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE, USERNAME, PWD);
//            System.out.println("Connected to DB");
        } catch (SQLException ex){
            
        }
    }
        
    protected static void close() {
        //Dong ket noi toi database
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                
            }
        }    
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                
            }
        }
        statement = null;
        conn = null;
    }
    
    //Tao bang booking
    public static void initBookingTable() {
        
        open();
        
        String sql = "select * from booking";
        try {
            statement = conn.prepareStatement(sql);
            
//            System.out.println("Checking booking table");
            
            ResultSet resultSet = statement.executeQuery();
            
            if (!resultSet.next()) {
//                System.out.println("Checking empty booking table");
                List<schedule> dataList = new ArrayList<>();
                dataList = scheduleEntity.list();

                for (schedule scd : dataList) {
                    long timeDiff = Math.abs(scd.getEnd_date().getTime() - scd.getStart_date().getTime());
                    int daysDiff = (int) (timeDiff / (1000 * 60 * 60 * 24));
                    for (int i=0; i<daysDiff; i++) {
                        String day = scd.getStart_date().toLocalDate().plusDays(i).getDayOfWeek().toString();
                        if (day.compareToIgnoreCase("SUNDAY") == 0) continue;
                        switch (scd.getClass_id()) {
                            case 1:
                                switch (day) {
                                    case "MONDAY":
                                    case "WEDNESDAY":
                                    case "FRIDAY":
                                        booking b = new booking(scd.getId(), scd.getId(), Timestamp.valueOf(scd.getStart_date().toLocalDate().plusDays(i).toString() + " 07:00:00"), Timestamp.valueOf(scd.getStart_date().toLocalDate().plusDays(i).toString() + " 11:00:00"));
                                        bookingEntity.insert(b);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case 2:
                                switch (day) {
                                    case "TUESDAY":
                                    case "THURSDAY":
                                    case "SATURDAY":
                                        booking b = new booking(scd.getId(), scd.getId(), Timestamp.valueOf(scd.getStart_date().toLocalDate().plusDays(i).toString() + " 07:00:00"), Timestamp.valueOf(scd.getStart_date().toLocalDate().plusDays(i).toString() + " 11:00:00"));
                                        bookingEntity.insert(b);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case 3:
                                switch (day) {
                                    case "MONDAY":
                                    case "WEDNESDAY":
                                    case "FRIDAY":
                                        booking b = new booking(scd.getId(), scd.getId(), Timestamp.valueOf(scd.getStart_date().toLocalDate().plusDays(i).toString() + " 13:30:00"), Timestamp.valueOf(scd.getStart_date().toLocalDate().plusDays(i).toString() + " 17:30:00"));
                                        bookingEntity.insert(b);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case 4:
                                switch (day) {
                                    case "TUESDAY":
                                    case "THURSDAY":
                                    case "SATURDAY":
                                        booking b = new booking(scd.getId(), scd.getId(), Timestamp.valueOf(scd.getStart_date().toLocalDate().plusDays(i).toString() + " 13:30:00"), Timestamp.valueOf(scd.getStart_date().toLocalDate().plusDays(i).toString() + " 17:30:00"));
                                        bookingEntity.insert(b);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            default:
                                System.out.println("Out of class_id");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
    }
}
