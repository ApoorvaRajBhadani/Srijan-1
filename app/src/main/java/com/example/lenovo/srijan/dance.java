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

public class dance extends AppCompatActivity {


    private List<cards> cardsList;
    danceadapter adapter;
    TextView slide2HeadingTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_slide2);



        // recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        slide2HeadingTextView = (TextView) findViewById(R.id.slide2_heading_textView);
        slide2HeadingTextView.setText("DANCE");


        cardsList = new ArrayList<>();




        //addimg items to list
        //R.color.card1,R.color.card2,R.color.card3;
        cardsList.add(new cards(R.color.card1, "Footloose", R.drawable.footloose));//yha pr salsa ki jagah event name or image bhi change krna
        cardsList.add(new cards(R.color.card2, "Reflection",  R.drawable.reflection));
        cardsList.add(new cards(R.color.card3, "Streetbeats",  R.drawable.streetbeats));
        cardsList.add(new cards(R.color.card1, "Hustle herd",  R.drawable.hustleherd));
        adapter = new danceadapter(dance.this, cardsList);

        recyclerView.setAdapter(adapter);

    }
    @Override
    public void finish() {
        super.finish();
       overridePendingTransition(R.anim.slide_out_out,R.anim.slide_in_in);
    }
}

