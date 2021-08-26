package com.example.app_cielo.activities.users;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;
import com.example.app_cielo.daos.UserDAO;
import com.example.app_cielo.enums.Roles;
import com.example.app_cielo.models.User;

public class UserShowActivity extends AppCompatActivity {
    private User user;
    private UserDAO userDAO;
    TextView textHeader, textShowCPF, textShowPhone, textShowRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_show_activity);
        userDAO = new UserDAO(this);
        user = userDAO.find(getIntent().getExtras().getInt("id"));

        textHeader = findViewById(R.id.textHeader);
        textShowCPF = findViewById(R.id.textShowCPF);
        textShowPhone = findViewById(R.id.textShowPhone);
        textShowRole = findViewById(R.id.textShowRole);

        textHeader.setText(user.getFullName());
        textShowCPF.setText(String.valueOf(user.getCPF()));
        textShowPhone.setText(String.valueOf(user.getPhone()));
        textShowRole.setText(Roles.stringfy(user.getRole()));

        getSupportActionBar().hide(); //esconder actionbar
    }

    public void back(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }
}
