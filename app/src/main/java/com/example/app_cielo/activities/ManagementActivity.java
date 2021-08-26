package com.example.app_cielo.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;

public class ManagementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_activity);
        getSupportActionBar().hide(); //esconder actionbar

    }
}