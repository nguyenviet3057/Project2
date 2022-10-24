/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group2.project2;

import com.group2.project2.entities.bookingEntity;
import com.group2.project2.entities.scheduleEntity;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Darkin
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(MasterAppController.DATETIME.isBefore(bookingEntity.findByScheduleId(1).get(1).getEnd_time().toLocalDateTime()));
/*
        LocalDateTime timeUnit = LocalDateTime.parse("2002-12-09T12:00:00");
        LocalDate ld = LocalDate.now();
        System.out.println(ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        Date dt = Date.valueOf("2002-12-12 12:00:00");
        Timestamp dt = Timestamp.valueOf("2002-12-09 12:00:00");
        System.out.println(dt);
        
        Date d = Date.valueOf("2022-09-28");
        d.toLocalDate().plusDays(1);
        Date n = Date.valueOf(LocalDate.now());
        DayOfWeek day = d.toLocalDate().getDayOfWeek();
        System.out.println(day.toString() == "WEDNESDAY");
        long timeDiff = Math.abs(n.getTime() - d.getTime());
        int daysDiff = (int) (timeDiff / (1000 * 60 * 60 * 24));
        System.out.println(" The number of days between dates: " + daysDiff);
       
//        LocalDateTime myDateObj = LocalDateTime.now();
//        System.out.println("Before formatting: " + myDateObj);
//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//
//        String formattedDate = myDateObj.format(myFormatObj);
//        System.out.println("After formatting: " + formattedDate);
        System.out.println("LOCAL Time: " + LocalDateTime.now().toLocalTime().toString().substring(0, 5));
*/
    }
}
