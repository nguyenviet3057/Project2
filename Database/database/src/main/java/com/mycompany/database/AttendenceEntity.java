package com.mycompany.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AttendenceEntity extends BaseEntity {
    public static void insert(Attendence ate) {
        open();

        try {
            String sql = "insert into Attendence(id, booking_id, attendence1, attendence2, note) values (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, ate.getId());
            statement.setInt(2, ate.getBooking_id());
            statement.setString(3, ate.getAttendence1());
            statement.setString(4, ate.getAttendence2());
            statement.setString(5, ate.getNote());

            statement.execute();

        } catch (SQLException e) {
            close();
        }
    }

    public static void update(Attendence ate) {
        open();

        try {
            String sql = "update students set booking_id = ?, attendence1 = ?, attendence2 = ?, note = ? where id = ?";

            statement = conn.prepareStatement(sql);
            statement.setInt(1, ate.getId());
            statement.setInt(2, ate.getBooking_id());
            statement.setString(3, ate.getAttendence1());
            statement.setString(4, ate.getAttendence2());
            statement.setString(5, ate.getNote());

            statement.execute();
        } catch (SQLException e) {
        }

        close();
    }

    public static void delete(int Id) {
        open();

        String sql = "delete * from Attendence where Id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, Id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }

        close();
    }

    public static Attendence findById(int id) {
        Attendence ate = null;

        open();

        String sql = "select * from Attendence where id = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ate = new Attendence(
                        resultSet.getInt("Id"),
                        resultSet.getInt("Booking_id"),
                        resultSet.getString("Attendence1"),
                        resultSet.getString("Attendence2"),
                        resultSet.getString("note"));


                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsEntity.class.getName()).log(Level.SEVERE,
                    null, ex);
        }


        close();

        return ate;
    }

}