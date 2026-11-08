package com.example.unchat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton see_more = v.findViewById(R.id.imageButton_seemore);
        Button accept = v.findViewById(R.id.button_accept);
        Button reject = v.findViewById(R.id.button_reject);


        //On click image button see_more
        see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //see_more code

            }
        });                     //see_more onClick code end

        //On click button accept
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //accept code
            }
        });                     //accept onClick code end

        //On click button reject
        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reject code
            }
        });                     //reject onClick code end


        return v;
    }                           //method onCreate end

//    protected void change_view(Integer avatar_address, String username, String[] intrests, String bio){
//        ImageView imageview_avatar = findViewById(R.id.imageView_avatar);
//        imageview_avatar.setImageResource(avatar_address);
//        TextView textview_username = findViewById(R.id.textView_username);
//        textview_username.setText(username);
//        TextView textview_Bio = findViewById(R.id.textView_bio);
//        textview_Bio.setText(bio);
//
//    }


}                               //class MainActivity end