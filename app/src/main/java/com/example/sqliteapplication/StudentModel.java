package com.example.sqliteapplication;

public class StudentModel {

    private String name;
    private String age;
    private String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age+"yrs";
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setAddress(String address) {
        this.contact = address;
    }
}
