package com.example.app_cielo.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_cielo.R;

public class LoginActivityFirebase extends AppCompatActivity{
    private static final String TAG = "LoginActivityFirebase";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private EditText mEmail, mPassword;
    private Button submit_btn;

    //email: gabriel@gmail.com
    //password: 123456

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity01);

        mEmail = (EditText) findViewById(R.id.user);
        mPassword = (EditText) findViewById(R.id.password);
        submit_btn = (Button) findViewById(R.id.submit_btn);

        this.mAuth = FirebaseAuth.getInstance();

        this.mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in" + user.getUid());
                    Toast.makeText(LoginActivityFirebase.this, "Logado com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    //User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    //Toast.makeText(LoginActivityFirebase.this, "Usuário: " + user.getUid(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(LoginActivityFirebase.this, "E-mail: " + user.getEmail(), Toast.LENGTH_SHORT).show();

                    Toast.makeText(LoginActivityFirebase.this, "Deslogado com sucesso!", Toast.LENGTH_SHORT).show();
                }
            }
        };

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String pass = mPassword.getText().toString();
                //String email = "gab@gmail.com";
                //String pass = "123456";

                if (!email.equals("") && !pass.equals("")) {
                    mAuth.signInWithEmailAndPassword(email, pass);

                } else {
                    Toast.makeText(LoginActivityFirebase.this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        getSupportActionBar().hide(); //esconder actionbar
    }

//        btnSignOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mAuth.signOut();
//                System.out.println("Deslogado com sucesso!");
//            }
//        });
//    }

    @Override
    public void onStart() {
        super.onStart();
        this.mAuth.addAuthStateListener(this.mAuthStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(this.mAuthStateListener != null) {
            this.mAuth.removeAuthStateListener(this.mAuthStateListener);
        }
    }
}