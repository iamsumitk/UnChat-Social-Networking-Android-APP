package com.example.settingactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Accounts extends AppCompatActivity {
    public EditText oldPass,newPass,confirmPass;
    ImageButton back,check;
     Toolbar accounts_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        oldPass = findViewById(R.id.oldpassword);
        newPass = findViewById(R.id.newpassword);
        confirmPass = findViewById(R.id.confirmpassword);
        accounts_toolbar = findViewById(R.id.accounts_toolbar);
        setSupportActionBar(accounts_toolbar);
        back = findViewById(R.id.accounts_toolbar_back);
        check = findViewById(R.id.accounts_toolbar_check);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setting_back = new Intent(Accounts.this, MainActivity.class);
                startActivity(setting_back);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newPass == confirmPass)
                {
                    // check if same
                    Toast.makeText(Accounts.this, "correct", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Accounts.this, "Not Correct", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}