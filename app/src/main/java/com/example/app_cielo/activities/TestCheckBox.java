package com.example.app_cielo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;

public class TestCheckBox extends AppCompatActivity {
    private CheckBox ch1, ch2, ch3;
    private Button btnSubmit, btnHabilitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testcheckbox);

        btnHabilitar = findViewById(R.id.btn_habillitar);
        btnHabilitar.setEnabled(false);

        init();

        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnHabilitar = (Button) findViewById(R.id.btn_habillitar);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ch1 = (CheckBox) findViewById(R.id.ch1);
                ch2 = (CheckBox) findViewById(R.id.ch2);
                ch3 = (CheckBox) findViewById(R.id.ch3);

                StringBuffer result = new StringBuffer();

                result.append("Hobbies:\n");

                if (ch1.isChecked()) {
                    result.append(ch1.getText().toString()).append("\n");
                }
                if (ch2.isChecked()) {
                    result.append(ch2.getText().toString()).append("\n");
                }
                if (ch3.isChecked()) {
                    result.append(ch3.getText().toString()).append("\n");
                }

                Toast.makeText(TestCheckBox.this, result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void init() {
        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);
        btnSubmit=findViewById(R.id.btn_submit);
    }
}