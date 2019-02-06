package com.example.lenovo.srijan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class danceadapter extends RecyclerView.Adapter<danceadapter.danceadapterviewholder> {
    private Context mctx;
    private List<cards> cardlist;

    public danceadapter(Context mctx, List<cards> cardlist) {
        this.mctx = mctx;
        this.cardlist = cardlist;
    }

    @NonNull
    @Override
    public danceadapterviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater =  LayoutInflater.from(mctx);
        View view = layoutInflater.inflate(R.layout.card, null);
        return new danceadapter.danceadapterviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final danceadapterviewholder danceadapterviewholder, int i) {
        final cards cards = cardlist.get(i);
        final DatabaseReference ref= FirebaseDatabase.getInstance().getReference("dates");

        final String[] date = new String[1];
        ref.child(cards.getTitletext()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    date[0] = dataSnapshot.getValue().toString();
                    danceadapterviewholder.textdesc.setText(date[0]);
                }

                Log.d("EventsActivity", "onDataChange: " + date[0]);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        danceadapterviewholder.titletext.setText(cards.getTitletext());

        danceadapterviewholder.sideimage.setImageResource(cards.getSidecolor());//add color
        Picasso.get().load(cards.getLogos()).into(danceadapterviewholder.logoimage);

    }

    @Override
    public int getItemCount() {
        return cardlist.size();
    }


    class danceadapterviewholder extends RecyclerView.ViewHolder{
        ImageView sideimage,logoimage;
        TextView titletext,textdesc;

        public danceadapterviewholder(@NonNull View itemView) {
            super(itemView);
            sideimage =itemView.findViewById(R.id.sidebar);
            logoimage = itemView.findViewById(R.id.logo);
            titletext = itemView.findViewById(R.id.headtext);
            textdesc = itemView.findViewById(R.id.desc);
            itemView.setOnClickListener(new View.OnClickListener() {
                AppCompatActivity appCompatActivity;
                @Override
                public void onClick(View v) {
                    cards cards = cardlist.get(getAdapterPosition());


                    if(cards.getTitletext().equals("Footloose")){
                        Intent intent = new Intent(mctx,Footloose.class);
                        mctx.startActivity(intent);
                        if(mctx instanceof dance)//yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((dance) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Reflection")){
                        Intent intent = new Intent(mctx,Reflection.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof dance)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((dance) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Streetbeats")){
                        Intent intent = new Intent(mctx,Streetbeats.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof dance)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((dance) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Hustle herd")){
                        Intent intent = new Intent(mctx,HustleHerd.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof dance)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((dance) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Aaroh")){
                        Intent intent = new Intent(mctx,Aaroh.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof Musical)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((Musical) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Unplugged")){
                        Intent intent = new Intent(mctx,Unplugged.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof Musical)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((Musical) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Pair on Stage")){
                        Intent intent = new Intent(mctx, PairOnStage.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof Musical)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((Musical) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Pop Culture Quiz")){
                        Intent intent = new Intent(mctx, PopQuiz.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof Quiz)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((Quiz) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Sports Quiz")){
                        Intent intent = new Intent(mctx, SportsQuiz.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof Quiz)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((Quiz) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Business Quiz")){
                        Intent intent = new Intent(mctx, BusinessQuiz.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof Quiz)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((Quiz) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("General Quiz")){
                        Intent intent = new Intent(mctx, GeneralQuiz.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof Quiz)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((Quiz) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Standup")){
                        Intent intent = new Intent(mctx, Standup.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof Literary)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((Literary) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Trichonia")){
                        Intent intent = new Intent(mctx, Trichonia.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof Literary)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((Literary) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }
                    if(cards.getTitletext().equals("Head on")){
                        Intent intent = new Intent(mctx, HeadOn.class);//todo:change to class
                        mctx.startActivity(intent);
                        if(mctx instanceof Literary)//todo:yha pr dance ki jagah jis class se arahe hai vo likhna.for example agar games se arahe hai toh games likhna

                            ((Literary) mctx).overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

                    }

                }
            });
        }
    }
}
