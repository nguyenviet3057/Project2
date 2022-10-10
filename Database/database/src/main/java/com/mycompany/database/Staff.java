/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;

/**
 *
 * @author ADMIN
 */
public class Staff {
    private int id;
    private String name;
    private int permission_id;
    private String  birthday;
    private String address;
    private String phone_number;
    private String email;
    private String pic;
    private float salary;

    public Staff(int id) {
        this.id = id;
    }

    public Staff(String name) {
        this.name = name;
    }

    public Staff(int id, String name, int permission_id, String birthday, String address, String phone_number,
                 String email, String pic, float salary) {
        this.id = id;
        this.name = name;
        this.permission_id = permission_id;
        this.birthday = birthday;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.pic = pic;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "com.mycompany.database.Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permission_id=" + permission_id +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", pic='" + pic + '\'' +
                ", salary=" + salary +
                '}';
    }
}
