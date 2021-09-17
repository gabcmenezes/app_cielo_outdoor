package com.example.app_cielo.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;

import java.text.DateFormat;
import java.util.Calendar;

public class InventoryActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button button_photograph1;
    ImageView imageView;
    int SELECT_IMAGE_CODE;
    Button button_photograph2;
    ImageView imageView2;
    Button button_photograph3;
    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_activity);

        button_photograph1=findViewById(R.id.button_photograph1);
        imageView=findViewById(R.id.pickedImage);
        button_photograph2=findViewById(R.id.button_photograph2);
        imageView2=findViewById(R.id.pickedImage2);
        button_photograph3=findViewById(R.id.button_photograph3);
        imageView3=findViewById(R.id.pickedImage3);

        button_photograph1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SELECT_IMAGE_CODE=1;
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Title"), SELECT_IMAGE_CODE);
            }
        });

        button_photograph2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SELECT_IMAGE_CODE=2;
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Title"), SELECT_IMAGE_CODE);
            }
        });

        button_photograph3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SELECT_IMAGE_CODE=3;
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Title"), SELECT_IMAGE_CODE);
            }
        });

        radioGroup = findViewById(R.id.radioGroup);

        getSupportActionBar().hide(); //esconder actionbar

    }

    public void back (View view){
        //startActivity(new Intent(this, AuditOutdoor.class));
        finish();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            Uri uri=data.getData();
            imageView.setImageURI(uri);
            button_photograph1.setText("TROCAR IMAGEM");
        }
        if(requestCode == 2){
            Uri uri=data.getData();
            imageView2.setImageURI(uri);
            button_photograph2.setText("TROCAR IMAGEM");
        }
        if(requestCode == 3){
            Uri uri=data.getData();
            imageView3.setImageURI(uri);
            button_photograph3.setText("TROCAR IMAGEM");
        }
    }
}
