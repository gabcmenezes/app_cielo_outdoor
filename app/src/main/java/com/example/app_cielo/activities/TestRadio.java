package com.example.app_cielo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;

import java.util.ArrayList;

public class TestRadio extends AppCompatActivity {
    private CheckBox ch1, ch2, ch3;
    Button btnSubmit, btnSubmit2, btnSubmit3;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    private TextView mResultTextView;
    private ArrayList<String>mResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testradio);

        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);
        btnSubmit = findViewById(R.id.button_apply);
        btnSubmit2 = findViewById(R.id.button_apply2);
        btnSubmit3 = findViewById(R.id.button_apply3);
        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);
        mResultTextView = findViewById(R.id.result);
        mResult = new ArrayList<>();
        mResultTextView.setEnabled(false);

        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch1.isChecked())
                    mResult.add("ch1");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String s : mResult)
                        stringBuilder.append(s).append("\n");

                    btnSubmit.setText(stringBuilder.toString());
                    btnSubmit.setEnabled(true);
            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch2.isChecked())
                    mResult.add("ch2");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String s : mResult)
                        stringBuilder.append(s).append("\n");

                    btnSubmit2.setText(stringBuilder.toString());
                    btnSubmit2.setEnabled(true);
            }
        });

        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch3.isChecked())
                    mResult.add("ch3");
                else
                    btnSubmit3.setEnabled(false);
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : mResult)
                    stringBuilder.append(s).append("\n");

                    btnSubmit3.setText(stringBuilder.toString());
                    btnSubmit3.setEnabled(true);
            }
        });

        /*btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : mResult)
                    stringBuilder.append(s).append("\n");

                btnSubmit.setText(stringBuilder.toString());
                btnSubmit.setEnabled(false);
            }
        });*/
    }

    public void checkButton(View v) {

        if(ch1.isChecked())
        {
            // true,do the task
            Toast.makeText(this, "CH1: " + ch1.getText(),
                    Toast.LENGTH_SHORT).show();
        }
        else
        {

        }

    }
}
