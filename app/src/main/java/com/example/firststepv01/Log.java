package com.example.firststepv01;

import java.util.Date;

public class Log {

    String fromLog = null, activityLog = null;
    Date date;

    public Log(Date date, String activityLog){
        this.date = date;
        this.activityLog = activityLog;
    }

    public Log(String fromLog, Date date){
        this.fromLog = fromLog;
        this.date = date;
    }

    public String getFromLog() {
        return fromLog;
    }

    public void setFromLog(String fromLog) {
        this.fromLog = fromLog;
    }

    public String getActivityLog() {
        return activityLog;
    }

    public void setActivityLog(String activityLog) {
        this.activityLog = activityLog;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
