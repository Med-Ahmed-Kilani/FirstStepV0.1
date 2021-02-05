package com.example.firststepv01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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


public class Register extends Activity {

    Button registerButton;
    TextView toLogin;
    EditText name, phone, email, password, reffSub;
    ProgressBar progressBar;
    Connection connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBar = findViewById(R.id.progressBar);
        reffSub = findViewById(R.id.reffSub);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        registerButton = findViewById(R.id.cirRegisterButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String inputUsername = name.getText().toString().trim();
                final String inputEmail = email.getText().toString().trim();
                final String inputPassword = password.getText().toString().trim();
                final String inputReffsub = reffSub.getText().toString().trim();

                progressBar.setVisibility(View.VISIBLE);

                if (inputEmail.equals(null)||inputPassword.equals(null)||inputReffsub.equals(null)||inputUsername.equals(null)){

                }

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        // Creating array for parameters
                        String[] field = new String[4];
                        field[0] = "reff";
                        field[1] = "username";
                        field[2] = "email";
                        field[3] = "password";

                        //Creating array for data

                        String[] data = new String[4];
                        data[0] = inputReffsub;
                        data[1] = inputUsername;
                        data[2] = inputEmail;
                        data[3] = inputPassword;

                        PutData putData = new PutData("http://192.168.1.8/LoginAndRegister/signup.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                progressBar.setVisibility(View.GONE);
                                String result = putData.getResult();
                                if (result.equals("Sign Up Success")){
                                    Intent intent = new Intent(getApplicationContext(),Login.class);
                                    startActivity(intent);
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        //End Write and Read data with URL
                    }
                });
            }

        });

        toLogin = findViewById(R.id.toLogin);

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
