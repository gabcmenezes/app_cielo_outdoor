package com.example.app_cielo.activities.six_ms;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;

public class SixMsManagement extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.six_ms_management_activity);
        getSupportActionBar().hide(); //esconder actionbar
    }
}
