/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2.entities;

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
    static final String DATABASE = "eproject";
    static final String USERNAME = "root";
    static final String PWD = "";
    static Connection conn = null;
    static PreparedStatement statement = null;
    
    protected static void open(){
        //Mo ket noi toi database
        try{
            System.out.println("Try connecting to DB");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE, USERNAME, PWD);
            System.out.println("Connected to DB");
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
    }
