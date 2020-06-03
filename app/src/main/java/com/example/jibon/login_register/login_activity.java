package com.example.jibon.login_register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jibon.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_activity extends AppCompatActivity {
    private static final String TAG = "Tag";
    Button signUpButton;
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;
    private EditText phoneNumber;
    private EditText password;

    private Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        phoneNumber=findViewById(R.id.user_number);
        password=findViewById(R.id.user_pswd);
        signUpButton = findViewById(R.id.button_signup);
        loginbutton =findViewById(R.id.login);
        mAuth=FirebaseAuth.getInstance();

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String getPhoneNumber=phoneNumber.getText().toString().trim();
               String getPassword=password.getText().toString().trim();

               mAuth.signInWithEmailAndPassword(getPhoneNumber,getPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Log.d(TAG, "createUserWithEmail:success");
                            Toast toast=Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else {
                            Log.d(TAG, "createUserWithEmail:unsuccessful");
                            Toast toast=Toast.makeText(getApplicationContext(),"Unsuccessful",Toast.LENGTH_SHORT);
                            toast.show();
                        }
                   }
               });

            }
        });

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
