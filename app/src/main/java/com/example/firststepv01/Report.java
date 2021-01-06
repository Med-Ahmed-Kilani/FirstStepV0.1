package com.example.firststepv01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Report extends AppCompatActivity {

    EditText topicReport, reportMessage;
    Button reportBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        topicReport = findViewById(R.id.topic_report);
        reportMessage = findViewById(R.id.report_msg);

        reportBtn = findViewById(R.id.report_button);

        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = "ahmedkilani890@gmail.com";
                String subject = topicReport.getText().toString().trim();
                String message = reportMessage.getText().toString().trim();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                try {
                    startActivity(Intent.createChooser(email, "Send mail..."));
                    finish();
                    Toast.makeText(Report.this,"Finished sending email...",Toast.LENGTH_SHORT).show();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Report.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
                startActivity(Intent.createChooser(email,"ahmedkilani890@gmail.com"));
            }
        });

    }
}