package com.example.app_cielo.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;


public class SecurityActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.security_activity);
        getSupportActionBar().hide(); //esconder actionbar
    }
}
