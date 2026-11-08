package com.example.unchat;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_setting, container, false);
    return view;
    }
    public void open_notifications(View view)
    {
        Intent notification_tab = new Intent(getContext(),Notifications.class);
        startActivity(notification_tab);
    }

    public void open_personalInfo(View view)
    {
        Intent notification_tab = new Intent(getContext(),PersonalInformation.class);
        startActivity(notification_tab);
    }

    public void open_changePassword(View view)
    {
        Intent notification_tab = new Intent(getContext(),ChangePassword.class);
        startActivity(notification_tab);
    }
}
