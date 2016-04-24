package com.example.fvosb.dumpsterfire.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.fvosb.dumpsterfire.R;
import com.example.fvosb.dumpsterfire.models.Reservation;
import com.example.fvosb.dumpsterfire.models.ReservationManager;

public class SearchTrainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // instance vars
    public Spinner depart;
    public Spinner arrive;

    public String departString;
    public String arriveString;
    public String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_train);

        // set up drop down spinners
        depart = (Spinner) findViewById(R.id.departSpinner);
        arrive = (Spinner) findViewById(R.id.arriveSpinner);

        // need spinner adapter
        ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(this,
                R.array.train_stations, android.R.layout.simple_spinner_item);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        depart.setAdapter(spinAdapter);
        arrive.setAdapter(spinAdapter);

        // set up selection listeners
        depart.setOnItemSelectedListener(this);
        arrive.setOnItemSelectedListener(this);

        Button search = (Button) findViewById(R.id.trainSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(v);
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View v, int pos, long id){
        // I know switch statements are insanely bad design, but not going for perfect so...
        switch((int) id) {
            case R.id.departSpinner:
                departString = parent.getItemAtPosition(pos).toString();
                break;
            case R.id.arriveSpinner:
                arriveString = parent.getItemAtPosition(pos).toString();
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void search(View v) {
        // set up a new reservation
        Reservation r = new Reservation();
        r.add("Depart", departString);
        r.add("Arrive", arriveString);
        r.add("Date", date);

        // add the reservation to the reservation manager for tracking
        ReservationManager.addResrvation(r);
        ReservationManager.setCurrentReservation(r);

        startActivity(new Intent(this, SelectDepartureActivity.class));
    }
}
