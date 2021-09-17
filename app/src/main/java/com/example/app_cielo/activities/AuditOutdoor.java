package com.example.app_cielo.activities;

import static androidx.constraintlayout.motion.widget.Debug.getLocation;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.app_cielo.R;
import com.example.app_cielo.activities.users.UsersActivity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AuditOutdoor extends AppCompatActivity implements LocationListener {
    private CheckBox ch1, ch2, ch3, ch4, ch5, ch6;
    Button bt_submit, btnSubmit, btnSubmit2, btnSubmit3, btnPreencherSeg, btnPreencherInf, btnPreencherEst, btnPreencherLog, btnPreencherCou, btnPreencherGes;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    EditText editName, editTextDate, editFilial, editCodigoSAP, editCNPJ, editEndereco, editCEP, editLocalizacaoAtual, editNomeParticipantes, editPontoFocalPA, editConsideracoesFinais;
    private TextView mResultTextView;
    private ArrayList<String>mResult;

    TextView localizacaoAtual;
    LocationManager locationManager;
    Button preencherSeg, preencherInf, preencherEst, preencherLog, preencherCou, preencherGes, btnLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.audit_outdoor_activity);
        getSupportActionBar().hide(); //esconder actionbar

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.editTextDate);
        textViewDate.setText(currentDate);

        bt_submit = findViewById(R.id.bt_submit);
        editName = findViewById(R.id.editName);
        editName.addTextChangedListener(textWatcher);
        editTextDate = findViewById(R.id.editTextDate);
        editTextDate.addTextChangedListener(textWatcher);
        editFilial = findViewById(R.id.editFilial);
        editFilial.addTextChangedListener(textWatcher);
        editCodigoSAP = findViewById(R.id.editCodigoSAP);
        editCodigoSAP.addTextChangedListener(textWatcher);
        editCNPJ = findViewById(R.id.editCNPJ);
        editCNPJ.addTextChangedListener(textWatcher);
        editEndereco = findViewById(R.id.editEndereco);
        editEndereco.addTextChangedListener(textWatcher);
        editCEP = findViewById(R.id.editCEP);
        editCEP.addTextChangedListener(textWatcher);
        editLocalizacaoAtual = findViewById(R.id.editLocalizacaoAtual);
        editLocalizacaoAtual.addTextChangedListener(textWatcher);
        editNomeParticipantes = findViewById(R.id.editNomeParticipantes);
        editNomeParticipantes.addTextChangedListener(textWatcher);
        editPontoFocalPA = findViewById(R.id.editPontoFocalPA);
        editPontoFocalPA.addTextChangedListener(textWatcher);
        editConsideracoesFinais = findViewById(R.id.editConsideracoesFinais);
        editConsideracoesFinais.addTextChangedListener(textWatcher);

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

        ////////////////////////////////////INÍCIO CHECK BUTTON//////////////////////////////////////

        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);
        ch4 = findViewById(R.id.ch4);
        ch5 = findViewById(R.id.ch5);
        ch6 = findViewById(R.id.ch6);
        btnPreencherSeg = findViewById(R.id.btnPreencherSeg);
        btnPreencherInf = findViewById(R.id.btnPreencherInf);
        btnPreencherEst = findViewById(R.id.btnPreencherEst);
        btnPreencherLog = findViewById(R.id.btnPreencherLog);
        btnPreencherCou = findViewById(R.id.btnPreencherCou);
        btnPreencherGes = findViewById(R.id.btnPreencherGes);
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
                mResult.clear();
                if (ch1.isChecked()){
                    mResult.add("Formulário [Segurança]");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String s : mResult)
                        stringBuilder.append(s).append("\n");

                    btnPreencherSeg.setText(stringBuilder.toString());
                    btnPreencherSeg.setEnabled(true);
                }else{
                    mResult.add("Formulário [Segurança]");
                    btnPreencherSeg.setEnabled(false);
                }
            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResult.clear();
                if (ch2.isChecked()){
                    mResult.add("Formulário [Infraestrutura]");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String s : mResult)
                        stringBuilder.append(s).append("\n");

                    btnPreencherInf.setText(stringBuilder.toString());
                    btnPreencherInf.setEnabled(true);
                }else{
                    mResult.add("Formulário [Infraestrutura]");
                    btnPreencherInf.setEnabled(false);
                }
            }
        });

        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResult.clear();
                if (ch3.isChecked()) {
                    mResult.add("Formulário [Estoque]");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String s : mResult)
                        stringBuilder.append(s).append("\n");

                    btnPreencherEst.setText(stringBuilder.toString());
                    btnPreencherEst.setEnabled(true);
                }else{
                    mResult.add("Formulário [Estoque]");
                    btnPreencherEst.setEnabled(false);
                }
            }
        });

        ch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResult.clear();
                if (ch4.isChecked()) {
                    mResult.add("Formulário [Logística]");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String s : mResult)
                        stringBuilder.append(s).append("\n");

                    btnPreencherLog.setText(stringBuilder.toString());
                    btnPreencherLog.setEnabled(true);
                }else{
                    mResult.add("Formulário [Logística]");
                    btnPreencherLog.setEnabled(false);
                }
            }
        });

        ch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResult.clear();
                if (ch5.isChecked()) {
                    mResult.add("Formulário [Courrier]");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String s : mResult)
                        stringBuilder.append(s).append("\n");

                    btnPreencherCou.setText(stringBuilder.toString());
                    btnPreencherCou.setEnabled(true);
                }else{
                    mResult.add("Formulário [Courrier]");
                    btnPreencherCou.setEnabled(false);
                }
            }
        });

        ch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResult.clear();
                if (ch6.isChecked()) {
                    mResult.add("Formulário [Gestão]");
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String s : mResult)
                        stringBuilder.append(s).append("\n");

                    btnPreencherGes.setText(stringBuilder.toString());
                    btnPreencherGes.setEnabled(true);
                }else{
                    mResult.add("Formulário [Gestão]");
                    btnPreencherGes.setEnabled(false);
                }
            }
        });

        ////////////////////////////////////FIM CHECK BUTTON//////////////////////////////////////



        //////////////////////////////////INÍCIO LOCALIZAÇÃO/////////////////////////////////////


        localizacaoAtual = findViewById(R.id.editLocalizacaoAtual);
        btnLocation = findViewById(R.id.button_location);
        //Runtime permissions
        if (ContextCompat.checkSelfPermission(AuditOutdoor.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(AuditOutdoor.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }


        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create method
                getLocation();
            }
        });


    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5,AuditOutdoor.this);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, ""+location.getLatitude()+","+location.getLongitude(), Toast.LENGTH_SHORT).show();
        try {
            Geocoder geocoder = new Geocoder(AuditOutdoor.this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            String address = addresses.get(0).getAddressLine(0);

            localizacaoAtual.setText(address);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    //////////////////////////////////FIM LOCALIZAÇÃO/////////////////////////////////////




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
    ///////////////////////////////////INÍCIO CHECKBOX'S/////////////////////////////////////

    public void goToSecurityActivity(View view){
        startActivity(new Intent(this, SecurityActivity.class));
    }

    public void goToInfrastructureActivity(View view){
        startActivity(new Intent(this, InfrastructureActivity.class));
    }

    public void goToInventoryActivity(View view){
        startActivity(new Intent(this, InventoryActivity.class));
    }

    public void goToLogisticsActivity(View view){
        startActivity(new Intent(this, LogisticsActivity.class));
    }

    public void goToCourrierActivity(View view){
        startActivity(new Intent(this, CourrierActivity.class));
    }

    public void goToManagementActivity(View view){
        startActivity(new Intent(this, ManagementActivity.class));
    }
    ///////////////////////////////////FIM CHECKBOX'S/////////////////////////////////////

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
            String auditorsname = editName.getText().toString();
            String currentdate = editTextDate.getText().toString();
            String filial = editFilial.getText().toString();
            String sapcode = editCodigoSAP.getText().toString();
            String cnpj = editCNPJ.getText().toString();
            String address = editEndereco.getText().toString();
            String postalcode = editCEP.getText().toString();
            String currentlocation = editLocalizacaoAtual.getText().toString();
            String guestsname = editNomeParticipantes.getText().toString();
            String pasfocalpoint = editPontoFocalPA.getText().toString();
            String finalconsiderations = editConsideracoesFinais.getText().toString();

            if(!auditorsname.isEmpty() && !currentdate.isEmpty() && !filial.isEmpty() && !sapcode.isEmpty() && !cnpj.isEmpty() && !address.isEmpty() && !postalcode.isEmpty() && !currentlocation.isEmpty() && !guestsname.isEmpty() && !pasfocalpoint.isEmpty() && !finalconsiderations.isEmpty()){
                //ambos não estão vazios
                bt_submit.setEnabled(true);
            }else{
                bt_submit.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}