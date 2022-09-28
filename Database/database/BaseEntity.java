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
                 Logger.getLogger(studentsEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(subjectsEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(subclassEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(statusEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(semesterEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(scheduleEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(permissionEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(notificationEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(markEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(classesEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(bookingEntity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                 Logger.getLogger(studentsEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(subjectsEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(subclassEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(statusEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(staffEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(semesterEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(scheduleEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(permissionEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(notificationEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(markEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(classesEntity.class.getName()).log(Level.SEVERE, null, ex);
                 Logger.getLogger(bookingEntity.class.getName()).log(Level.SEVERE, null, ex);
                 
            }
        }
        statement = null;
        conn = null;
    }
    }
