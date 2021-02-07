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
    TextView toLogin, usenameError, emailError, passwordError, confirmPassError ;
    EditText name, email, password, confirmPass;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBar = findViewById(R.id.progressBar);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPass = findViewById(R.id.confirmPassword);
        usenameError = findViewById(R.id.usernameError);
        emailError = findViewById(R.id.emailError);
        passwordError = findViewById(R.id.passwordError);
        confirmPassError = findViewById(R.id.confirmPasswordError);

        registerButton = findViewById(R.id.cirRegisterButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String inputUsername = name.getText().toString().trim();
                final String inputEmail = email.getText().toString().trim();
                final String inputPassword = password.getText().toString();
                final String inputConfirmPass = confirmPass.getText().toString();

                Boolean pass = true;

                usenameError.setVisibility(View.GONE);
                emailError.setVisibility(View.GONE);
                passwordError.setVisibility(View.GONE);
                confirmPassError.setVisibility(View.GONE);

                if (inputUsername.length()<5){
                    pass = false;
                    usenameError.setVisibility(View.VISIBLE);
                }

                if ((inputEmail.length()<10)||!(inputEmail.contains("@"))||(!(inputEmail.contains(".fr"))&&!(inputEmail.contains(".com")))){
                    pass = false;
                    emailError.setVisibility(View.VISIBLE);
                }

                if (inputPassword.length()<8){
                    pass = false;
                    passwordError.setVisibility(View.VISIBLE);
                }

                if (!(inputConfirmPass.equals(inputPassword))){
                    pass = false;
                    confirmPassError.setVisibility(View.VISIBLE);
                }

                if (pass){
                    progressBar.setVisibility(View.VISIBLE);

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            // Creating array for parameters
                            String[] field = new String[3];
                            field[0] = "username";
                            field[1] = "email";
                            field[2] = "password";

                            //Creating array for data

                            String[] data = new String[3];
                            data[0] = inputUsername;
                            data[1] = inputEmail;
                            data[2] = inputPassword;

                            PutData putData = new PutData("http://192.168.1.3/LoginAndRegister/signup.php", "POST", field, data);
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
