package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.chat.fragmentsAdapters.chatAdapter;
import com.example.chat.model.messageModel;

import java.util.ArrayList;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatDetailActivity extends AppCompatActivity {
    TextView username;
    CircleImageView profileImage;
    Toolbar chattingToolbar;
    ImageButton back,send;
    RecyclerView recyclerView;
    EditText message_edit_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);
        username = findViewById(R.id.chat_username);
        profileImage = findViewById(R.id.chat_profile_pic);
        chattingToolbar = findViewById(R.id.chatting_toolbar);
        setSupportActionBar(chattingToolbar);
        back = findViewById(R.id.back_chat_button);

        String recieved_userName = getIntent().getStringExtra("username");
        Integer recived_image = getIntent().getIntExtra("profilePic",0);

        username.setText(recieved_userName);
        profileImage.setImageResource(recived_image);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatDetailActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        final ArrayList<messageModel> messagemodels = new ArrayList<>();
        final chatAdapter chatadapter = new chatAdapter(messagemodels,ChatDetailActivity.this,recieved_userName);
        recyclerView = findViewById(R.id.chat_recyclerView);
        recyclerView.setAdapter(chatadapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChatDetailActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        String sender_username = "Sonu"; // this is the username have to fatch from the database

        final String senderRoot = sender_username + recieved_userName;
        final String reciverRoot = recieved_userName + sender_username;




        send = findViewById(R.id.send);
        message_edit_text = findViewById(R.id.enter_message);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = message_edit_text.getText().toString();
                final messageModel m_model = new messageModel(sender_username,message);
                m_model.setTimestamp(new Date().getTime());
                message_edit_text.setText("");

                // after that we have to store the sender id and message into the database;
            }
        });

    }
}