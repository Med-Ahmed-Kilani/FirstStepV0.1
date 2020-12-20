package com.example.firststepv01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Withdraw extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button submitButtonWithdraw;
    EditText phoneNumberd17, amountToWithdraw, accountNumberCED;
    Spinner spinner;
    LinearLayout d17Layout, cbLayout, cedLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        submitButtonWithdraw = findViewById(R.id.submitButtonWithdraw);
        phoneNumberd17 = findViewById(R.id.phoneNumberD17);
        amountToWithdraw = findViewById(R.id.amountToWithdraw);
        accountNumberCED = findViewById(R.id.accountNumberCED);
        spinner = findViewById(R.id.spinner);
        d17Layout = findViewById(R.id.D17LayoutPayment);
        cbLayout = findViewById(R.id.cbLayoutPayment);
        cedLayout = findViewById(R.id.carteEdinarLayoutPayment);

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Withdraw_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position).equals("D17")){
            disable();
            amountToWithdraw.setVisibility(View.VISIBLE);
            d17Layout.setVisibility(View.VISIBLE);
            submitButtonWithdraw.setVisibility(View.VISIBLE);
        } else if (parent.getItemAtPosition(position).equals("Carte Bancaire")){
            disable();
            cbLayout.setVisibility(View.VISIBLE);
        } else {
            disable();
            amountToWithdraw.setVisibility(View.VISIBLE);
            cedLayout.setVisibility(View.VISIBLE);
            submitButtonWithdraw.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void disable() {
        submitButtonWithdraw.setVisibility(View.GONE);
        amountToWithdraw.setVisibility(View.GONE);
        d17Layout.setVisibility(View.GONE);
        cbLayout.setVisibility(View.GONE);
        cedLayout.setVisibility(View.GONE);
    }
}