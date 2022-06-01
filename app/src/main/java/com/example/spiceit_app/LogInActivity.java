package com.example.spiceit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.loginbutton) Button mLogInButton;
    @BindView(R.id.PersonName) EditText mPersonName;
    @BindView(R.id.password) EditText mPassword;
    @BindView(R.id.confirmpass) EditText mConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);

        mLogInButton.setOnClickListener(this);
    }
            @Override
            public void onClick(View v) {
                login();
                String user = mPersonName.getText().toString();
                Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                intent.putExtra("name", user);

                startActivity(intent);




        };
    public void login () {
        String pass = mPassword.getText().toString().trim();
        String confrim = mConfirmPass.getText().toString().trim();
        if(pass.equals("spiceitapp" ) && confrim.equals("spiceitapp"))
        {
            Toast.makeText(this, "Passwords matched!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Passwords did not match", Toast.LENGTH_SHORT).show();

    }

}
}