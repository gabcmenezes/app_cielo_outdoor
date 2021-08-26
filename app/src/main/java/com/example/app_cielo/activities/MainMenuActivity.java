package com.example.app_cielo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;
import com.example.app_cielo.activities.users.UsersActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);
        getSupportActionBar().hide(); //esconder actionbar
    }

    public void goToUsers(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }

    public void goToStartActivity(View view) {
        startActivity(new Intent(this, LoginActivity01.class));
    }
}
