package com.example.lenovo.srijan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Developers extends AppCompatActivity {


    private ArrayList<DeveloperModel> developersList = new ArrayList<>();
    private ArrayList<DeveloperModel> designersList = new ArrayList<>();
    private ListView developersListView;
    private ListView designersListView;
    private DeveloperAdapter developerAdapter;
    private DeveloperAdapter designersAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        developersListView = findViewById(R.id.developers_listview);
        designersListView = findViewById(R.id.designers_listview);

        developersList.add(new DeveloperModel(R.drawable.ic_launcher_foreground,"Perul Jain","B.Tech. 2nd year","perul-jain-55845b154","https://github.com/peruljain","peruljain","perul.jain"));
        developersList.add(new DeveloperModel(R.drawable.ic_launcher_foreground,"Perul Jain","B.Tech. 2nd year","perul-jain-55845b154","https://github.com/peruljain","peruljain","perul.jain"));
        developersList.add(new DeveloperModel(R.drawable.ic_launcher_foreground,"Perul Jain","B.Tech. 2nd year","perul-jain-55845b154","https://github.com/peruljain","peruljain","perul.jain"));
        designersList.add(new DeveloperModel(R.drawable.ic_launcher_foreground,"Perul Jain","B.Tech. 2nd year","perul-jain-55845b154","https://github.com/peruljain","peruljain","perul.jain"));
        designersList.add(new DeveloperModel(R.drawable.ic_launcher_foreground,"Perul Jain","B.Tech. 2nd year","perul-jain-55845b154","https://github.com/peruljain","peruljain","perul.jain"));

        developerAdapter = new DeveloperAdapter(Developers.this,developersList);
        designersAdapter = new DeveloperAdapter(Developers.this,designersList);
        developersListView.setAdapter(developerAdapter);
        designersListView.setAdapter(designersAdapter);
    }
}
