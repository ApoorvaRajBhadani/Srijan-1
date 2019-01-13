package com.example.lenovo.srijan;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class informals extends  MainActivity {

    private List<cards> cardsList;
    adaptermain adapter;
    TextView slide1HeadingTextView;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.slide1, R.id.main);
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ImageView imageView = (ImageView) findViewById(R.id.nav);
        slide1HeadingTextView = (TextView)findViewById(R.id.slide1_heading_textView);
        slide1HeadingTextView.setText("INFORMALS");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        // recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        cardsList = new ArrayList<>();
        //addimg items to list
        //yaha pr change titletext me jo me  naam dunga vo ayenge,drawable me image club name se save krna;
        cardsList.add(new cards(R.color.card1, "Magic Mirrors", "Grip Your Toes to Dance", R.drawable.mirror));
        cardsList.add(new cards(R.color.colorAccent, "Now you see me (Talent Search Platform)", "Grip Your Toes to Dance", R.drawable.talent));
        cardsList.add(new cards(R.color.colorAccent, "Prom", "Grip Your Toes to Dance", R.drawable.prom));
        cardsList.add(new cards(R.color.colorAccent, "Silent DJ", "Grip Your Toes to Dance", R.drawable.silentdj));
        cardsList.add(new cards(R.color.colorAccent, "Karaoke", "Grip Your Toes to Dance", R.drawable.karaoke));
        cardsList.add(new cards(R.color.colorAccent, "DJ Battle", "Grip Your Toes to Dance", R.drawable.djbattle));
        cardsList.add(new cards(R.color.colorAccent, "Zorbing", "Grip Your Toes to Dance", R.drawable.zorbing));
        cardsList.add(new cards(R.color.colorAccent, "Photo Booth", "Grip Your Toes to Dance", R.drawable.photobooth));
        cardsList.add(new cards(R.color.colorAccent, "Movie Screening", "Grip Your Toes to Dance", R.drawable.photobooth));
        adapter = new adaptermain(informals.this,cardsList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(informals.this,MainActivity.class));
    }
}
