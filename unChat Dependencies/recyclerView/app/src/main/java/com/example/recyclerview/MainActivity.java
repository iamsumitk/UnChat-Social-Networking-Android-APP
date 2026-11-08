package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ConnectionData[] connections = new ConnectionData[]{
                new ConnectionData("Sonu Kumar",
                        "he is a nice Guy",R.drawable.ic_baseline_connect_without_contact_24),
                new ConnectionData("Sonu Kumar",
                        "he is a nice Guy",R.drawable.ic_baseline_connect_without_contact_24),
                new ConnectionData("Sonu Kumar",
                        "he is a nice Guy",R.drawable.ic_baseline_connect_without_contact_24),
                new ConnectionData("Sonu Kumar",
                        "he is a nice Guy",R.drawable.ic_baseline_connect_without_contact_24),
                new ConnectionData("Sonu Kumar",
                        "he is a nice Guy",R.drawable.ic_baseline_connect_without_contact_24),
                new ConnectionData("Sonu Kumar",
                        "he is a nice Guy",R.drawable.ic_baseline_connect_without_contact_24)
        };

        ConnectionAdapter connectionAdapter = new ConnectionAdapter(connections
                ,MainActivity.this);
        recyclerView.setAdapter(connectionAdapter);
    }
}