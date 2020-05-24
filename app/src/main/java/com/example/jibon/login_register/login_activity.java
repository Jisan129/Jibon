package com.example.jibon.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jibon.R;

public class login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
    }

    private void SendUserToRegisterActivity() {
        Intent registerIntent = new Intent(login_activity.this,register_activity.class);//going from login activity to main activity
        startActivity (registerIntent);

    }
}
