package com.example.fvosb.dumpsterfire.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fvosb.dumpsterfire.R;

public class AddSchoolInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_school_info);

        Button backButton = (Button) findViewById(R.id.AddSchoolBack);
        Button submitButton = (Button) findViewById(R.id.AddSchoolSubmit);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(v);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit(v);
            }
        });
    }

    public void back(View view) {
        startActivity(new Intent(this, FunctionalityActivity.class));
    }

    public void submit(View view) {
        // probably add some SQL stuff here
        startActivity(new Intent(this, FunctionalityActivity.class));
    }
}
