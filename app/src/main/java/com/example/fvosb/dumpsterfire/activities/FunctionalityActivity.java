package com.example.fvosb.dumpsterfire.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fvosb.dumpsterfire.R;

public class FunctionalityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functionality);

        Button viewSchedule = (Button) findViewById(R.id.viewScheduleButton);
        Button makeReservation = (Button) findViewById(R.id.makeReservationButton);
        Button updateReservation = (Button) findViewById(R.id.updateReservationButton);
        Button cancelReservation = (Button) findViewById(R.id.cancelReservationButton);
        Button giveReview = (Button) findViewById(R.id.giveReviewButton);
        Button addSchoolInfo = (Button) findViewById(R.id.addSchoolInfoButton);
        Button viewReview = (Button) findViewById(R.id.viewReviewButton);
        Button logout = (Button) findViewById(R.id.logoutButton);

        viewSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSchedule(v);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout(v);
            }
        });

        makeReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeReservation(v);
            }
        });

        addSchoolInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSchoolInfo(v);
            }
        });

        viewReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewReview(v);
            }
        });
    }

    public void viewSchedule(View v) {
        startActivity(new Intent(this, ViewScheduleActivity.class));
    }

    public void logout(View v) {
        // member manager maybe
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void makeReservation(View v) {
        startActivity(new Intent(this, SearchTrainActivity.class));
    }

    public void addSchoolInfo(View v) {
        startActivity(new Intent(this, AddSchoolInfoActivity.class));
    }

    public void viewReview(View v) {
        startActivity(new Intent(this, ViewReviewActivity.class));
    }
}
