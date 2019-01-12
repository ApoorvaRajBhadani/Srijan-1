package com.example.lenovo.srijan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;

public class salsa extends AppCompatActivity {
    adaptermain2 adaptermain2;//cards adapter
    List<photo> photoList;
    String[] photos = {"https://firebasestorage.googleapis.com/v0/b/srijan-6df05.appspot.com/o/photos%2Fimg1.jpg?alt=media&token=1082e395-1e4c-4579-a1b8-0bdbb21b9b3b","https://firebasestorage.googleapis.com/v0/b/srijan-6df05.appspot.com/o/photos%2Fimhg2.jpg?alt=media&token=5ee1f8b1-8bef-4049-aebe-86dbe76fd334"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.slide3);

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler3);
        recyclerView.setLayoutManager(new LinearLayoutManager(salsa.this,HORIZONTAL,true));
        recyclerView.setHasFixedSize(true);

        photoList = new ArrayList<>();
        photoList.add( new photo(photos[0]));
        photoList.add( new photo(photos[1]));
        photoList.add( new photo(photos[0]));
        photoList.add( new photo(photos[1]));
        adaptermain2 = new adaptermain2(salsa.this,photoList);
        recyclerView.setAdapter(adaptermain2);



    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_out_out,R.anim.slide_in_in);
    }
}
