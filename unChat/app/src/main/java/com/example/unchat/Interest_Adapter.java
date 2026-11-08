package com.example.unchat;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Interest_Adapter extends RecyclerView.Adapter<Interest_Adapter.ViewHolder> {

    String[] intrests;
    Context context;

    public Interest_Adapter(String[] intrests, Context activity) {
        this.intrests = intrests;
        this.context = activity;
    }

    @NonNull
    @Override
    public Interest_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.interest_adapter,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Interest_Adapter.ViewHolder holder, int position) {
        holder.interest_textView.setText(intrests[position]);
        Interests_Screen mainActivity = new Interests_Screen();
        Interests_Screen.Selected_Category= intrests[position]; // used for fetching the subcategories of that parent category
        holder.interest_textView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Toast.makeText(context,Interests_Screen.Selected_Category, Toast.LENGTH_SHORT).show();
                holder.interest_textView.setBackgroundColor(R.color.chat_background);
            }
        });

    }

    @Override
    public int getItemCount() {
        return intrests.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView interest_textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            interest_textView = itemView.findViewById(R.id.intrest_textview);
        }
    }
}
