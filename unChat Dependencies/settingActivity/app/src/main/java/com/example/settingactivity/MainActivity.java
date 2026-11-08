package com.example.settingactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void open_notifications(View view)
    {
        Intent notification_tab = new Intent(this,Notifications.class);
        startActivity(notification_tab);
    }

    public void open_personalInfo(View view)
    {
        Intent notification_tab = new Intent(this,PersonalInformation.class);
        startActivity(notification_tab);
    }

    public void open_changePassword(View view)
    {
        Intent notification_tab = new Intent(this,Accounts.class);
        startActivity(notification_tab);
    }

}