package com.project.eatit.Model;

import androidx.annotation.NonNull;

import java.util.List;

public  class Request implements CharSequence {

    private String phone;
    private String name;
    private String address;
    private String total;
    private String status;

    private List<Order> foods;

    public Request(String phone, String name, String s, String toString, List<Order> cart) {
    }

    public Request(String phone, String name, String address, String total, String status, List<Order> foods) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.total = total;
        this.status = "0";
        this.foods = foods;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @NonNull
    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
