package com.example.firststepv01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button loginButton;
    TextView toRegister;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressBar);
        loginButton = findViewById(R.id.cirLoginButton);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        toRegister = findViewById(R.id.toRegister);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String inputEmail = email.getText().toString().trim();
                final String inputPassword = password.getText().toString();

                progressBar.setVisibility(View.VISIBLE);

                if (inputEmail.equals(null)||inputPassword.equals(null)){

                }

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        // Creating array for parameters
                        String[] field = new String[2];
                        field[0] = "email";
                        field[1] = "password";

                        //Creating array for data

                        String[] data = new String[2];
                        data[0] = inputEmail;
                        data[1] = inputPassword;

                        PutData putData = new PutData("http://192.168.1.8/LoginAndRegister/login.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                //progressBar.setVisibility(View.GONE);
                                String result = putData.getResult();
                                if (result.equals("Login Success")){
                                    Intent intent = new Intent(getApplicationContext(),LogsPage.class);
                                    startActivity(intent);
                                }
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        }
                        //End Write and Read data with URL
                    }
                });
            }

        });


        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }
}