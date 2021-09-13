package com.example.app_cielo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;
import com.example.app_cielo.activities.users.UsersActivity;

import java.text.DateFormat;
import java.util.Calendar;

public class AuditOutdoor extends AppCompatActivity {

    private CheckBox ch1;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button preencherSeg, preencherInf, preencherEst, preencherLog, preencherCou, preencherGes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audit_outdoor_activity);
        getSupportActionBar().hide(); //esconder actionbar

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.editTextDate);
        textViewDate.setText(currentDate);

        preencherSeg = findViewById(R.id.btnPreencherSeg);
        preencherSeg.setEnabled(false);
        preencherInf = findViewById(R.id.btnPreencherInf);
        preencherInf.setEnabled(false);
        preencherEst = findViewById(R.id.btnPreencherEst);
        preencherEst.setEnabled(false);
        preencherLog = findViewById(R.id.btnPreencherLog);
        preencherLog.setEnabled(false);
        preencherCou = findViewById(R.id.btnPreencherCou);
        preencherCou.setEnabled(false);
        preencherGes = findViewById(R.id.btnPreencherGes);
        preencherGes.setEnabled(false);
        
        radioGroup = findViewById(R.id.radioGroup);

        Button buttonApply = findViewById(R.id.btnPreencherSeg);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);
            }
        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Resposta: " + radioButton.getText(), Toast.LENGTH_SHORT).show();

        if (radioButton.getText() == "Segurança") {
            preencherSeg = findViewById(R.id.btnPreencherSeg);
            preencherSeg.setEnabled(true);
        } else if (radioButton.getText() == "Infraestrutura") {
            preencherInf = findViewById(R.id.btnPreencherInf);
            preencherInf.setEnabled(true);
        } else if (radioButton.getText() == "Estoque") {
            preencherEst = findViewById(R.id.btnPreencherEst);
            preencherEst.setEnabled(true);
        } else if (radioButton.getText() == "Logística") {
            preencherLog = findViewById(R.id.btnPreencherLog);
            preencherLog.setEnabled(true);
        } else if (radioButton.getText() == "Courrier") {
            preencherCou = findViewById(R.id.btnPreencherCou);
            preencherCou.setEnabled(true);
        } else if (radioButton.getText() == "Gestão") {
            preencherGes = findViewById(R.id.btnPreencherGes);
            preencherGes.setEnabled(true);
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }

    public void save(View view) {
        Toast.makeText(AuditOutdoor.this, "Dados salvos com sucesso!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String rb = radioButton.getText().toString();

            if (!rb.isEmpty()) {
                preencherSeg.setEnabled(true);
            } else {
                preencherSeg.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
