package com.example.potatodiseasemobileapp;
public class UserData {
    String full_name,user_name,phone_no,email,password;
    public UserData(){}

    public UserData(String full_name, String user_name, String phone_no,String email, String password) {
        this.full_name = full_name;
        this.user_name = user_name;
        this.phone_no = phone_no;
        this.email = email;
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}