package com.example.jibon.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jibon.R;

public class register_activity extends AppCompatActivity {
    String[] blood_group, blood_donate;
    Spinner bld_spinner, bld_donate_spinner;
    TextView blood, donate;


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
    }


}
