package com.example.chat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chat.R;
import com.example.chat.fragmentsAdapters.ConnectionAdapter;
import com.example.chat.fragmentsAdapters.ConnectionData;


public class Chats extends Fragment {
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_chats, container, false);
        recyclerView = view.findViewById(R.id.chat_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ConnectionData[] connections = new ConnectionData[]{
                new ConnectionData("Sonu Kumar",
                        "Hello",R.drawable.ic_baseline_connect_without_contact_24),
                new ConnectionData("sumit Kumar",
                        "he is a nice Guy",R.drawable.ic_baseline_connect_without_contact_24),
                new ConnectionData("viney Kumar",
                        "he is a nice Guy",R.drawable.ic_baseline_connect_without_contact_24),
                new ConnectionData("Sonu Kumar",
                        "he is a nice Guy",R.drawable.ic_baseline_connect_without_contact_24),
                new ConnectionData("Sonu Kumar",
                        "he is a nice Guy",R.drawable.ic_baseline_connect_without_contact_24),
                new ConnectionData("Sonu Kumar",
                        "he is a nice Guy",R.drawable.ic_baseline_connect_without_contact_24)
        };
        ConnectionAdapter connectionAdapter = new ConnectionAdapter(connections,getContext());
        recyclerView.setAdapter(connectionAdapter);
        return view;
    }
}