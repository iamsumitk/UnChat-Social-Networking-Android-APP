package com.example.unchat;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ConnectionAdapter extends RecyclerView.Adapter<ConnectionAdapter.ViewHolder> {

    ConnectionData[] connections;
    ConnectionFragment context;

    public ConnectionAdapter(ConnectionData[] connectionData, ConnectionFragment activity) {
        this.connections = connectionData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ConnectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.connectionadapter,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConnectionAdapter.ViewHolder holder, int position) {
        final ConnectionData connectionDatalist = connections[position];
        holder.textView_username.setText(connectionDatalist.getUsername());
        holder.textView_desc.setText(connectionDatalist.getDesc());
        holder.connection_image.setImageResource(connectionDatalist.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getContext(), connectionDatalist.getUsername() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return connections.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView connection_image;
        TextView textView_username;
        TextView textView_desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            connection_image = itemView.findViewById(R.id.connection_image);
            textView_username = itemView.findViewById(R.id.connection_username);
            textView_desc = itemView.findViewById(R.id.connection_desc);


        }
    }
}
