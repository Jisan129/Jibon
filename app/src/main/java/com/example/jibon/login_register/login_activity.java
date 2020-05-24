package com.example.jibon.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jibon.R;

public class login_activity extends AppCompatActivity {
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        signUpButton = findViewById(R.id.button_signup);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToRegisterActivity();
            }
        });
    }

    public void SendUserToRegisterActivity() {
        Intent registerIntent = new Intent(login_activity.this,register_activity.class);//going from login activity to main activity
        startActivity (registerIntent);

    }
}
