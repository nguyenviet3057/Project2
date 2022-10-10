/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BaseEntity {
    static final String DATABASE = "ABC";
    static final String USERNAME = "root";
    static final String PWD = "";
    static Connection conn = null;
    static PreparedStatement statement = null;
    
    protected static void open(){
        //Mo ket noi toi database
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" 
                                    + DATABASE, USERNAME, PWD);
        } catch (SQLException ex){
            
        }
    }
        
    protected static void close() {
        //Dong ket noi toi database
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                 Logger.getLogger(StudentsEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(SubjectsEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(SubclassEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(StatusEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(StaffEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(SemesterEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(ScheduleEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(PermissionEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(NotificationEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(MarkEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(BookingEntity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                 Logger.getLogger(StudentsEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(SubjectsEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(SubclassEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(StatusEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(StaffEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(SemesterEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(ScheduleEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(PermissionEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(NotificationEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(MarkEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(ClassesEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(BookingEntity.class.getName()).log(Level.SEVERE, null, ex);
                 
            }
        }
        statement = null;
        conn = null;
    }
    }
