package com.project.eatit.Model;

public class user {

    private String Name;
    private String Pasword;
    private String Phone;
    private String IsStaff;

    public user() {
    }

    public user(String name, String pasword) {
        Name = name;
        Pasword = pasword;
        IsStaff = "false";
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPasword() {
        return Pasword;
    }

    public void setPasword(String pasword) {
        Pasword = pasword;
    }


}
