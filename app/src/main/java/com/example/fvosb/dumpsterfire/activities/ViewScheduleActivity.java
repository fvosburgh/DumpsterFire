package com.example.fvosb.dumpsterfire.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fvosb.dumpsterfire.R;
import com.example.fvosb.dumpsterfire.models.TrainManager;

public class ViewScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);

        Button searchButton = (Button) findViewById(R.id.ViewScheduleSearchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scheduleSearch(v);
            }
        });
    }

    public void scheduleSearch(View view) {
        EditText trainNumber = (EditText) findViewById(R.id.ViewScheduleTrainNumber);
        String trainNumberString = trainNumber.getText().toString();

        TrainManager.getCurrTrain().setTrainNumber(trainNumberString);
        
        startActivity(new Intent(this, PopulatedScheduleActivity.class));
    }
}
