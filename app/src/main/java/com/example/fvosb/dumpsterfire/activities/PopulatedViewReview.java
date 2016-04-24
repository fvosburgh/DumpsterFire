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

public class PopulatedViewReview extends AppCompatActivity {

    public TableLayout reviewTable;
    public HashMap<String, String> dummyData = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populated_view_review);

        reviewTable = (TableLayout) findViewById(R.id.ViewReviewTable);

        TableRow headers = new TableRow(this);
        String[] heads = {"Rating", "Comment"};
        for (String header : heads) {
            TextView view = new TextView(this);
            view.setText(header);
            headers.addView(view);
        }

        reviewTable.addView(headers);

        dummyData.put("Rating", "Dank as fuck");
        dummyData.put("Comment", "Yeeeeeee fitty linin' numsayin");

        populateTable(dummyData);

        Button backButton = (Button) findViewById(R.id.PopulatedViewReviewBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(v);
            }
        });
    }

    public void populateTable(HashMap<String, String> data) {
        TableRow dataRow = new TableRow(this);

        TextView rating = new TextView(this);
        TextView comment = new TextView(this);

        rating.setText(data.get("Rating"));
        comment.setText(data.get("Comment"));

        dataRow.addView(rating);
        dataRow.addView(comment);

        reviewTable.addView(dataRow);
    }

    public void back(View view) {
        startActivity(new Intent(this, FunctionalityActivity.class));
    }
}
