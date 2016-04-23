package com.example.fvosb.dumpsterfire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(v);
            }
        });
    }

    public void login(View view) {
        EditText usernameText = (EditText) findViewById(R.id.LoginUsername);
        EditText passwordText = (EditText) findViewById(R.id.LoginPassword);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        if(username.equals("test") && password.equals("password")) {
            startActivity(new Intent(this, FunctionalityActivity.class));
        }
    }
}
