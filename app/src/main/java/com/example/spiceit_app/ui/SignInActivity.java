package com.example.spiceit_app.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.spiceit_app.R;
import com.example.spiceit_app.databinding.ActivitySignInBinding;
import com.example.spiceit_app.models.Validator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    ActivitySignInBinding signInBinding;
    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signInBinding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(signInBinding.getRoot());

        auth = FirebaseAuth.getInstance();
        authListener();
        signInBinding.loginbutton.setOnClickListener(this);


    }

    private void authListener() {
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();

                }
            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.removeAuthStateListener(authListener);
    }

    @Override
    public void onClick(View v) {
        if (v == signInBinding.loginbutton){
            String email = signInBinding.email.getText().toString().trim();
            String password = signInBinding.password.getText().toString().trim();
            String confirmPassword = signInBinding.confirmpass.getText().toString().trim();
            String name = signInBinding.PersonName.getText().toString().trim();

            Validator validator = new Validator();
            if (!validator.validateName(signInBinding.PersonName) || !validator.validateEmail(signInBinding.email) || !validator.validatePassword(signInBinding.password, signInBinding.confirmpass)){
                return;
            }
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()){
                    Toast.makeText(this, "Sign In Successful", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "Not Successful", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}