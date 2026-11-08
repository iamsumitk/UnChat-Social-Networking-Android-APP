package com.example.chat.fragmentsAdapters;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ConnectionData {
    private String username;
    private String lastMessage;
    private Integer image;

    public ConnectionData(String username, String lastMessage, Integer image) {
        this.username = username;
        this.lastMessage = lastMessage;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String desc) {
        this.lastMessage = desc;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

}
