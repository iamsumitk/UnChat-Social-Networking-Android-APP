package com.example.unchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class PersonalInformation extends AppCompatActivity {
    EditText email,birthDate;
    RadioGroup gender;
    ImageButton check,back;
    Toolbar personal_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);

        email = findViewById(R.id.info_email);
        birthDate = findViewById(R.id.info_birthday);
        gender = findViewById(R.id.Gender);
        // emial.setText(// entered email which user previously entered) and same and birthdate and male
        check = findViewById(R.id.personal_info_imageButton);
        back = findViewById(R.id.personal_info_back);
        personal_toolbar = findViewById(R.id.personal_info_toolbar);
        setSupportActionBar(personal_toolbar);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setting_back = new Intent(PersonalInformation.this, MainActivity.class);
                startActivity(setting_back);
            }
        });
    }


    void update_personalInfo(View view)
    {
        Toast.makeText(PersonalInformation.this, "Clicked", Toast.LENGTH_SHORT).show();
//        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                switch (i)
//                {
//                    case R.id.male:
//                    {
//                        Toast.makeText(PersonalInformation.this, "Male", Toast.LENGTH_SHORT).show();
//                        break;
//                    }
//                    case R.id.female:
//                    {
//                        Toast.makeText(PersonalInformation.this, "Female", Toast.LENGTH_SHORT).show();
//                        break;
//                    }
//                    case R.id.unknown:
//                    {
//                        Toast.makeText(PersonalInformation.this, "Unknown", Toast.LENGTH_SHORT).show();
//                        break;
//                    }
//                    default:
//                    {
//                        break;
//                    }
//                }
//            }
//        });
    }

}