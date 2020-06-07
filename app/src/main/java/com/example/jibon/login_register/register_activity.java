package com.example.jibon.login_register;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jibon.R;
import com.squareup.picasso.Picasso;

import java.net.URI;

public class register_activity extends AppCompatActivity {

    public static final int PICK_IMAGE=1;
    private static final String TAG ="Tag";
    String[] blood_group, blood_donate;
    Spinner bld_spinner, bld_donate_spinner;
    TextView blood, donate;
    EditText editName,phoneNumber,password;
    Button choosePhoto;
    ImageView profilePhoto;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        blood_group = getResources().getStringArray(R.array.blood_group);
        blood_donate = getResources().getStringArray(R.array.blood_donate);

        bld_spinner = findViewById(R.id.spinner_blood);
        bld_donate_spinner = findViewById(R.id.spinner_blood_donate);

        blood = findViewById(R.id.text_blood_input);
        donate = findViewById(R.id.donate_blood_input);
        editName=findViewById(R.id.edit_name);
        phoneNumber=findViewById(R.id.edit_number);
        password=findViewById(R.id.edit_password);
        choosePhoto=findViewById(R.id.choose_photo);
        profilePhoto=findViewById(R.id.profilePhoto);


        ArrayAdapter<String> blood_adapter = new ArrayAdapter<String>(this, R.layout.spinner_sample_view, R.id.text_view_sample, blood_group);
        ArrayAdapter<String> donate_adapter = new ArrayAdapter<String>(this, R.layout.spinner_sample_view, R.id.text_view_sample, blood_donate);

        bld_spinner.setAdapter(blood_adapter);
        bld_donate_spinner.setAdapter(donate_adapter);

        bld_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = bld_spinner.getSelectedItem().toString();
                blood.setText(value);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bld_donate_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value_donate = bld_donate_spinner.getSelectedItem().toString();
                donate.setText(value_donate);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //select photo

        choosePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoChooser();
            }
        });

    }

    private void photoChooser() {
        Intent intent =new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE&&resultCode==RESULT_OK&&data!=null&&data.getData()!=null){
         imageUri=data.getData();
            Picasso.get().load(imageUri).fit().into(profilePhoto);
            Toast.makeText(getApplicationContext(), "Image selected Successful", Toast.LENGTH_SHORT).show();
            Log.i(TAG,"Image selected Successfully");
        }
        else {
            Log.i(TAG,"No Image Selected");
            Toast.makeText(getApplicationContext(), "No Image Selected", Toast.LENGTH_SHORT).show();
        }

    }
}
