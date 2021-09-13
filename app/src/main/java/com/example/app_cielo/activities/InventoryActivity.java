package com.example.app_cielo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;

import java.text.DateFormat;
import java.util.Calendar;

public class InventoryActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_activity);

        radioGroup = findViewById(R.id.radioGroup);

        getSupportActionBar().hide(); //esconder actionbar

    }
    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Resposta: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
        if (radioButton.getText()=="Sim"){
            Toast.makeText(InventoryActivity.this, "sim!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(InventoryActivity.this, "não!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity01.class));
        }
    }
}
