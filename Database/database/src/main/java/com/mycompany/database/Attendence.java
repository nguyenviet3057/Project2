package com.mycompany.database;

public class Attendence {
    private int id;
    private int booking_id;
    private String attendence1;
    private String attendence2;
    private String note;

    public Attendence(int id) {
        this.id = id;
    }

    public Attendence(int id, int booking_id, String attendence1, String attendence2, String note) {
        this.id = id;
        this.booking_id = booking_id;
        this.attendence1 = attendence1;
        this.attendence2 = attendence2;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getAttendence1() {
        return attendence1;
    }

    public void setAttendence1(String attendence1) {
        this.attendence1 = attendence1;
    }

    public String getAttendence2() {
        return attendence2;
    }

    public void setAttendence2(String attendence2) {
        this.attendence2 = attendence2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "com.mycompany.database.Attendence{" +
                "id=" + id +
                ", booking_id=" + booking_id +
                ", attendence1='" + attendence1 + '\'' +
                ", attendence2='" + attendence2 + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
