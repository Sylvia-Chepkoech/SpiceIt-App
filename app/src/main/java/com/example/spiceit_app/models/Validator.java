package com.example.spiceit_app.models;

import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Pattern;

public class Validator {
    public boolean validateName(EditText name){
        String username = name.getText().toString().trim();
        if (username.isEmpty()){
            name.setError("Please enter name");
            return false;
        }else {
            name.setError(null);
            return true;
        }
    }

    public boolean validateEmail(EditText name){
        String username = name.getText().toString().trim();
        if (username.isEmpty()){
            name.setError("Please enter email");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
            name.setError("Please enter a valid email");
            return false;
        }
        else {
            name.setError(null);
            return true;
        }
    }
    public boolean validatePassword(EditText password, EditText confirmPass){
        String username = password.getText().toString().trim();
        String username2 = confirmPass.getText().toString().trim();
        if (username.isEmpty() ){
            password.setError("Please enter password");
            return false;
        }else if (username2.isEmpty()){
            confirmPass.setError("Please confirm your password");
            return false;
        }else if (!username.equals(username2)){
            password.setError("The passwords must match");
            return false;
        }
        else {
            password.setError(null);
            return true;

        }
    }

}
