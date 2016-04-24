package com.example.fvosb.dumpsterfire.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.fvosb.dumpsterfire.R;
import com.example.fvosb.dumpsterfire.models.Reservation;
import com.example.fvosb.dumpsterfire.models.ReservationManager;

import java.util.concurrent.TransferQueue;

public class TravelExtrasActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private String numBags;
    private String passName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_extras);

        Spinner spinner = (Spinner) findViewById(R.id.travelExtrasSpinner);
        // need spinner adapter
        ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(this,
                R.array.bag_numbers, android.R.layout.simple_spinner_item);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinAdapter);
        spinner.setOnItemSelectedListener(this);

        EditText passenger = (EditText) findViewById(R.id.passengerNameTravelExtra);
        passName = passenger.getText().toString();

        Button nextButton = (Button) findViewById(R.id.travelExtrasNextButton);
        nextButton.setOnClickListener(new TravelExtraListener(numBags, passName));

    }

    public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
        numBags = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void nextScreen(View v) {
        startActivity(new Intent(this, MakeReservationActivity.class));
    }

    private class TravelExtraListener implements View.OnClickListener {

        private String numBags;
        private String passName;

        public TravelExtraListener(String numBags, String passName) {
            this.numBags = numBags;
            this.passName = passName;
        }

        @Override
        public void onClick(View v) {
            Reservation r = ReservationManager.getCurrentReservation();
            r.add("Number of Bags", numBags);
            r.add("Passenger Name", passName);
            nextScreen(v);
        }
    }
}
