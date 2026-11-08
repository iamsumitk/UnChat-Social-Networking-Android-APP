package com.example.unchat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class LogIn_Screen extends AppCompatActivity {
    TextInputEditText username, password;
    Button login;
    String str_username, str_password;
    ProgressDialog dialog;

    private static String url = BuildConfig.BASE_URL;
    public static final String login_url = url + "login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);
        dialog  = new ProgressDialog(LogIn_Screen.this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.setTitle("Please Wait...");
                if (username.getText().toString().equals("")) {

                } if (password.getText().toString().equals("")) {

                } else {
                    str_username = username.getText().toString().trim();
                    str_password = password.getText().toString().trim();
                    new Login_BackGroundThread().execute();
                   // Login();
                }
            }
        });
    }

    void Login() {
        StringRequest request;
        request = new StringRequest(Request.Method.POST,
                login_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                if (response.equalsIgnoreCase("logged in successfully")) {
                    username.setText("");
                    password.setText("");
                    Toast.makeText(LogIn_Screen.this, "Logged-In", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LogIn_Screen.this, "UserName or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(LogIn_Screen.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Toast.makeText(LogIn_Screen.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //Toast.makeText(signup.this, "Successfully edited", Toast.LENGTH_SHORT).show();
                params.put("username", str_username);
                params.put("password", str_password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(LogIn_Screen.this);
        requestQueue.add(request);
    }


    public class Login_BackGroundThread extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
//            Dialog progressDialog = new Dialog(this);
//            progressDialog.setContentView(R.layout.loading_dialog);
//            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            progressDialog.setCancelable(false);
//            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String[] values) {
            Login();
            return "Done";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // progressDialog.dismiss();
//            Intent intent = new Intent(signup.this, Interests.class);
//            startActivity(intent);
        }
    }


    public void Register_Account(View view) {
        Intent intent = new Intent(this, Signup_Screen.class);
        startActivity(intent);
    }

}