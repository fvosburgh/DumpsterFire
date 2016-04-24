package com.example.fvosb.dumpsterfire.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.fvosb.dumpsterfire.R;

import java.util.HashMap;

public class PopulatedScheduleActivity extends AppCompatActivity {

    public TableLayout scheduleTable;
    public HashMap<String, String> dummyData = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populated_schedule);

        scheduleTable = (TableLayout) findViewById(R.id.ScheduleTable);

        // add table row for headers
        TableRow headers = new TableRow(this);
        String[] heads = {"Train Number", "Arrival Time", "Departure Time", "Station"};
        for (String header : heads) {
            TextView view = new TextView(this);
            view.setText(header);
            headers.addView(view);
        }

        scheduleTable.addView(headers);

        // adding dummy data
        dummyData.put("Train Number", "1337");
        dummyData.put("Arrival Time", "10:00am");
        dummyData.put("Departure Time", "10:15am");
        dummyData.put("Station", "Auschwitz");

        populateTable(dummyData);

        Button backButton = (Button) findViewById(R.id.PopulatedScheduleBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(v);
            }
        });
    }

    public void populateTable(HashMap<String, String> data) {
        TableRow dataRow = new TableRow(this);

        TextView tNumber = new TextView(this);
        TextView arrivalTime = new TextView(this);
        TextView departureTime = new TextView(this);
        TextView station = new TextView(this);

        tNumber.setText(data.get("Train Number"));
        arrivalTime.setText(data.get("Arrival Time"));
        departureTime.setText(data.get("Departure Time"));
        station.setText(data.get("Station"));

        dataRow.addView(tNumber);
        dataRow.addView(arrivalTime);
        dataRow.addView(departureTime);
        dataRow.addView(station);

        scheduleTable.addView(dataRow);
    }

    public void back(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
