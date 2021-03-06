package com.example.spiceit_app.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spiceit_app.R;
import com.example.spiceit_app.models.Validator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.loginbutton) Button mLogInButton;
    @BindView(R.id.PersonName) EditText mPersonName;
    @BindView(R.id.password) EditText mPassword;

    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);

        mLogInButton.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();
        authListener();
    }

    private void authListener() {
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null) {
                    Intent intent = new Intent(LogInActivity.this, MainActivity.class);
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
        if (v == mLogInButton){
            String email = mPersonName.getText().toString().trim();
            String password = mPassword.getText().toString().trim();

            Validator validator = new Validator();
            if (!validator.validateEmail(mPersonName) || !validator.validateName(mPassword))
                return;
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()){
                    Toast.makeText(this, "Log In Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Check email and password", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        }

    }
}
