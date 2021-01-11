package com.example.firststepv01;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHundler {
    Connection con;
    String uname, pass, ip, port, database;

    public Connection connectionclass() {
        uname="";
        ip="";
        pass="";
        port="";
        database="";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection connection = null;
        String ConnectionURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://"+ip+":"+port+";databasename="+database+";user="+uname+";password="+pass+";";
            connection = DriverManager.getConnection(ConnectionURL);
        }catch (Exception ex) {
            System.out.println("Error"+ex.getMessage());
        }

        return connection;
    }

    public void register (Worker worker){
        try {

        }catch (Exception ex){

        }
    }

}
