package com.example.spiceit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {
    @BindView(R.id.loginbutton) Button mLogInButton;
    @BindView(R.id.PersonName) EditText mPersonName;
    @BindView(R.id.password) EditText mPassword;
    @BindView(R.id.confirmpass) EditText mConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }
}