package com.example.firststepv01;

public class Log {
    int id;
    String date;
    Worker getter, giver;
    Ad ad;

    public Log(int id, String date, Worker getter, Worker giver, Ad ad) {
        this.id = id;
        this.date = date;
        this.getter = getter;
        this.giver = giver;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Worker getGetter() {
        return getter;
    }

    public void setGetter(Worker getter) {
        this.getter = getter;
    }

    public Worker getGiver() {
        return giver;
    }

    public void setGiver(Worker giver) {
        this.giver = giver;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
