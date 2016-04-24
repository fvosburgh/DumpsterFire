package com.example.fvosb.dumpsterfire.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.fvosb.dumpsterfire.R;
import com.example.fvosb.dumpsterfire.models.Reservation;
import com.example.fvosb.dumpsterfire.models.ReservationManager;
import com.example.fvosb.dumpsterfire.models.UserManager;

import java.util.ArrayList;

public class MakeReservationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TableLayout table;
    private ArrayList<Reservation> reservations = ReservationManager.getAllReservations();
    private String card;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_reservation);

        // set up current reservations table
        // make headers first
        table = (TableLayout) findViewById(R.id.reviewTable);

        TableRow headers = new TableRow(this);
        String[] heads = {"Train Number", "Date"};
        for (String head : heads) {
            TextView view = new TextView(this);
            view.setText(head);
            headers.addView(view);
        }

        // populate table
        populateTable();

        // populate spinner
        ArrayList<String> cards = UserManager.getCurrrentUser().getCards();

        Spinner spinner = (Spinner) findViewById(R.id.reviewSpinner);

        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinAdapter);
        for (String card : cards) {
            spinAdapter.add(card);
            spinAdapter.notifyDataSetChanged();
        }
        spinner.setOnItemSelectedListener(this);

        //display current total
        int cost = 0;
        for (Reservation r : reservations) {
            cost += Integer.parseInt(r.get("Ticket Price"));
        }
        TextView totalCost = (TextView) findViewById(R.id.totalCost);
        totalCost.setText(Integer.toString(cost));

        //set up button listeners
        Button addCard = (Button) findViewById(R.id.addNewCard);
        addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewCardScreen(v);
            }
        });

        Button addReservation = (Button) findViewById(R.id.addMoreReservations);
        addReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMoreReservationsScreen(v);
            }
        });

        Button submit = (Button) findViewById(R.id.reviewSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitScreen(v);
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
        card = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addNewCardScreen(View v) {

    }

    public void addMoreReservationsScreen(View v) {
        startActivity(new Intent(this, SearchTrainActivity.class));
    }

    public void submitScreen(View v) {
        // create total order from here
    }

    public void populateTable() {
        for(Reservation r : reservations) {
            TableRow row = new TableRow(this);
            String tNumber = r.get("Train Number");
            String date = r.get("Date");
            TextView tView = new TextView(this);
            TextView dView = new TextView(this);

            tView.setText(tNumber);
            dView.setText(date);

            row.addView(tView);
            row.addView(dView);

            table.addView(row);
        }
    }

}
