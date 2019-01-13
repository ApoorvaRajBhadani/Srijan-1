package com.example.lenovo.srijan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Photography extends AppCompatActivity {

    String value;
    private List<cards> cardsList;
    adaptermain adapter;
    TextView slide2HeadingTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide2);
        //firebase setup;
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("dates");

        // recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        slide2HeadingTextView = (TextView) findViewById(R.id.slide2_heading_textView);
        slide2HeadingTextView.setText("PHOTOGRAPHY");


        cardsList = new ArrayList<>();


        myRef.addValueEventListener(new ValueEventListener() {
            private static final String TAG = "hello";

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String url;
                //dataSnapshot = dataSnapshot.child("photos");
                if (dataSnapshot.exists()) {
                    String classname = getIntent().getStringExtra("actvityname");//firebase se dates ayegi
                    value = dataSnapshot.child("salsa").getValue().toString();//yha salsa ki jagah event name likhna or firebase database me update krlena
                    Log.d(TAG, "Value is: " + value);
                } else {
                    value = "updated soon";
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        //addimg items to list
        //R.color.card1,R.color.card2,R.color.card3;
        cardsList.add(new cards(R.color.card1, "Snappers", value, R.drawable.snappers));//yha pr salsa ki jagah event name or image bhi change krna
        cardsList.add(new cards(R.color.colorAccent, "Creative Canvas", "Grip Your Toes to Dance", R.drawable.creativecanvas));
        adapter = new adaptermain(Photography.this, cardsList);

        recyclerView.setAdapter(adapter);

    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_out_out,R.anim.slide_in_in);
    }
}

