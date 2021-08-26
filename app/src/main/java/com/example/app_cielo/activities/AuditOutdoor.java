package com.example.app_cielo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;
import com.example.app_cielo.activities.users.UsersActivity;

import java.text.DateFormat;
import java.util.Calendar;

public class AuditOutdoor extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audit_outdoor_activity);
        getSupportActionBar().hide(); //esconder actionbar

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.editTextDate);
        textViewDate.setText(currentDate);
    }

    public void back(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }

    public void save(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }
}
