package com.example.chat.fragmentsAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chat.R;
import com.example.chat.model.messageModel;

import java.util.ArrayList;

public class chatAdapter extends RecyclerView.Adapter{

    ArrayList<messageModel> messageModels;
    Context context;
    String reciver_userName;

    int sender_view_type = 1,reciver_view_type = 0;
    public chatAdapter(ArrayList<messageModel> messageModels, Context context) {
        this.messageModels = messageModels;
        this.context = context;
    }

    public chatAdapter(ArrayList<messageModel> messageModels, Context context, String reciver_userName) {
        this.messageModels = messageModels;
        this.context = context;
        this.reciver_userName = reciver_userName;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == sender_view_type)
        {
            View view = LayoutInflater.from(context).inflate(R.layout.samplesender,parent,false);
            return new SenderViewHolder(view);
        }
        else
        {
            View view = LayoutInflater.from(context).inflate(R.layout.samplereciver,parent,false);
            return new RecieverViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
       if(messageModels.get(position).getU_id().equals("102")) // in this we compare theuserid from database
       {
           return sender_view_type;
       }
       else
           return reciver_view_type;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         messageModel m_model = messageModels.get(position);

         if(holder.getClass() == SenderViewHolder.class)
         {
             ((SenderViewHolder) holder).senderMsg.setText(m_model.getMessage());
         }
         else
             ((RecieverViewHolder) holder).reciverMsg.setText(m_model.getMessage());
    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    public class RecieverViewHolder extends RecyclerView.ViewHolder{

        TextView reciverMsg,reciverTime;

        public RecieverViewHolder(@NonNull View itemView) {
            super(itemView);

            reciverMsg = itemView.findViewById(R.id.reciverText);
            reciverTime = itemView.findViewById(R.id.reciverTime);
        }
    }
    public class SenderViewHolder extends RecyclerView.ViewHolder{

        TextView senderMsg,senderTime;
        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);

            senderMsg = itemView.findViewById(R.id.senderText);
            senderTime = itemView.findViewById(R.id.senderTime);
        }
    }

}
