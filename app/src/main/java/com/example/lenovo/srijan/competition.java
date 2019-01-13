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

public class competition extends  MainActivity {

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
        slide1HeadingTextView.setText("COMPETITIONS");
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
        cardsList.add(new cards(R.color.card1, "Dance", "Grip Your Toes to Dance", R.drawable.footloose));
        cardsList.add(new cards(R.color.colorAccent, "Music", "Grip Your Toes to Dance", R.drawable.footloose));
     adapter = new adaptermain(competition.this,cardsList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(competition.this,MainActivity.class));
    }
}
