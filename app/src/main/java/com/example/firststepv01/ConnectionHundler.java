package com.example.firststepv01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHundler extends SQLiteOpenHelper {
    private static final String uname = "worker";
    private static final String pass = null;
    private static final String ip = null;
    private static String port = null;
    private static final String database = "workerManager" ;
    private static final int version = 1;



    public ConnectionHundler (Context context, String nom, SQLiteDatabase.CursorFactory cursorFactory, int version){
        super(context, nom, cursorFactory, version);
    }

    public ConnectionHundler (Context context){
        super(context, database, null, version);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @SuppressLint("NewApi")
    public Connection connectionclass() {


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
