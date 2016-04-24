package com.example.fvosb.dumpsterfire.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fvosb.dumpsterfire.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button registerButton = (Button) findViewById(R.id.RegisterButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register(v);
            }
        });
    }

    public void register(View view) {
        EditText usernameText = (EditText) findViewById(R.id.RegisterUsername);
        EditText emailText = (EditText) findViewById(R.id.RegisterEmail);
        EditText passwordText = (EditText) findViewById(R.id.RegisterPassword);
        EditText confirmText = (EditText) findViewById(R.id.RegisterConfirmPassword);

        startActivity(new Intent(this, FunctionalityActivity.class));
    }
}
