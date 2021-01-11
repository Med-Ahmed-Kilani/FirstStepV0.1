package com.example.firststepv01;

public class Worker {
    double balance;
    String name, mail, password;
    int id, reffSub;
    long phone;

    public Worker(double balance, String name, String mail,int reffSub, String password, long phone) {
        this.balance = balance;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.reffSub = reffSub;
    }

    public int getReffSub() {
        return reffSub;
    }

    public void setReffSub(int reffSub) {
        this.reffSub = reffSub;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
