package com.example.firststepv01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Register extends Activity {

    Button registerButton;
    TextView toLogin;
    EditText name, phone, email, password, reffSub;
    Connection connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reffSub = findViewById(R.id.reffSub);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        registerButton = findViewById(R.id.cirRegisterButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputEmail = email.getText().toString().trim();
                String inputPassword = password.getText().toString().trim();
                String inputReffsub = reffSub.getText().toString().trim();


                if (inputReffsub.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter your inviter code!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (inputEmail.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (inputPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (inputPassword.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }


               /* try {
                    ConnectionHundler connectionHundler = new ConnectionHundler();
                    connect = connectionHundler.connectionclass();
                    if (connect!=null){
                        String query= "INSERT INTO workers (inviter, name, phone, email, password)\n" +
                                "VALUES ("+reffSub+", "+name+", "+phone+", "+email+", "+password+");";
                        PreparedStatement preparedStatement =   connect.prepareStatement(query);
                        preparedStatement.executeUpdate();
                        Toast.makeText(getApplicationContext(),"passed",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"check connection", Toast.LENGTH_SHORT ).show();
                    }
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                }*/
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
