package com.example.lenovo.srijan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView nav,compition,informals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        nav = (ImageView)findViewById(R.id.nav);
        compition = (ImageView)findViewById(R.id.competitions);
        informals = (ImageView)findViewById(R.id.informals);
        compition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,competition.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                finish();
            }
        });
        informals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,informals.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                finish();
            }
        });
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }
    protected void replaceContentLayout(int sourceId, int destinationId) {
        View contentLayout = findViewById(destinationId);

        ViewGroup parent = (ViewGroup) contentLayout.getParent();
        int index = parent.indexOfChild(contentLayout);

        parent.removeView(contentLayout);
        contentLayout = getLayoutInflater().inflate(sourceId, parent, false);
        parent.addView(contentLayout, index);
    }

}
