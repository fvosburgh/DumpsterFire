package com.example.fvosb.dumpsterfire.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fvosb.dumpsterfire.R;
import com.example.fvosb.dumpsterfire.models.TrainManager;

public class ViewReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_review);

        Button backButton = (Button) findViewById(R.id.PopulatedViewReviewBack);
        Button submitButton = (Button) findViewById(R.id.ViewReviewSubmit);

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
        EditText trainNumber = (EditText) findViewById(R.id.ViewReviewTrainNumber);
        String trainNumberString = trainNumber.getText().toString();

        TrainManager.getCurrTrain().setTrainNumber(trainNumberString);

        //go to populated view review
        startActivity(new Intent(this, PopulatedViewReview.class));
    }
}
