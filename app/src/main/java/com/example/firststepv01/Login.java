package com.example.firststepv01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button loginButton;
    TextView toRegister;
    Connection connect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.cirLoginButton);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        final String inputEmail = email.getText().toString().trim();
        final String inputPass = password.getText().toString().trim();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* try {
                    ConnectionHundler connectionHundler = new ConnectionHundler();
                    connect = connectionHundler.connectionclass();
                    if (connect!=null){
                        String query= "select  email, password from workers where (email='"+inputEmail+"'&password='"+inputPass+"');";
                        PreparedStatement st = connect.prepareStatement(query);
                        ResultSet rs = st.executeQuery(query);


                        if (rs.equals(null)){
                            Toast.makeText(getApplicationContext(),"Login or password are false",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(),"passed",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"check connection", Toast.LENGTH_SHORT ).show();
                    }
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                }*/

                Intent intent = new Intent(getApplicationContext(), LogsPage.class);
                startActivity(intent);
            }
        });

        toRegister = findViewById(R.id.toRegister);

        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }

    public void onLogin(View view){
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        String type = "login";


    }
}