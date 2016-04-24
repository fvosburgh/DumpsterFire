package com.example.fvosb.dumpsterfire.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.fvosb.dumpsterfire.R;
import com.example.fvosb.dumpsterfire.models.Reservation;
import com.example.fvosb.dumpsterfire.models.ReservationManager;

import java.util.HashMap;

public class SelectDepartureActivity extends AppCompatActivity {

    public TableLayout resultsTable;
    public HashMap<String, String> dummyData = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_departure);

        resultsTable = (TableLayout) findViewById(R.id.selectDepartureTable);

        // add table row for headers
        TableRow headers = new TableRow(this);
        String[] heads = {"Train Number", "Time", "1st Class", "2nd Class"};
        for (String header : heads) {
            TextView view = new TextView(this);
            view.setText(header);
            headers.addView(view);
        }

        resultsTable.addView(headers);

        // dummy data for now
        /**
         * right now we use dummy data
         * with sql, we will cal a method that will get the relevant data and parse it
         * which will then be stored in a variable to be passed to populateTable()
         *
         * e.g
         *
         * data = DBConnector.getDepartureData().format();
         */
        dummyData.put("Train Number", "1111");
        dummyData.put("Time", "2222");
        dummyData.put("1st", "$123");
        dummyData.put("2nd", "$234");

        // populate table with data
        populateTable(dummyData);

        Button next = (Button) findViewById(R.id.selectDepartureNextButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextScreen(v);
            }
        });

        Button back = (Button) findViewById(R.id.selectDepartureBackButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backScreen(v);
            }
        });

    }

    public void populateTable(HashMap<String, String> data) {
        TableRow dataRow = new TableRow(this);
        TextView tNumber = new TextView(this);
        TextView time = new TextView(this);

        // the classes need to be selectable, so use linear layout with text view and radio button
        LinearLayout ll = new LinearLayout(this);
        RadioButton first = new RadioButton(this);
        RadioButton second = new RadioButton(this);

        first.setText(data.get("1st"));
        first.setOnClickListener(new TableRadioListener("Ticket Price", data.get("1st")));

        second.setText(data.get("2nd"));
        second.setOnClickListener(new TableRadioListener("Ticket Price", data.get("2nd")));

        ll.addView(first);
        ll.addView(second);

        tNumber.setText(data.get("Train Number"));
        time.setText(data.get("Time"));

        //add all of it to the table row
        dataRow.addView(tNumber);
        dataRow.addView(time);
        dataRow.addView(ll);

        //finally add the row to the table
        resultsTable.addView(dataRow);

    }

    public void nextScreen(View v) {
        startActivity(new Intent(this, TravelExtrasActivity.class));
    }

    public void backScreen(View v) {
        startActivity(new Intent(this, SearchTrainActivity.class));
    }

    // need custom on click listener so we can update reservation data on the fly
    // still brittle as it doesnt check to see if the current reservation
    // already has price data
    private class TableRadioListener implements View.OnClickListener {

        private String key;
        private String data;

        public TableRadioListener(String key, String data) {
            this.key = key;
            this.data = data.replace("$", "");
        }

        @Override
        public void onClick(View v) {
            Reservation r = ReservationManager.getCurrentReservation();
            r.add(key, data);
        }
    }
}
