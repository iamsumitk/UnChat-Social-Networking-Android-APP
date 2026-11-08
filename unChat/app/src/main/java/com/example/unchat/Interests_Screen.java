package com.example.unchat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

import java.util.HashMap;
import java.util.Map;

public class Interests_Screen extends AppCompatActivity {

    public static String Selected_Category;
    public static boolean check = false;
    String Interest_category;
    private static String url = BuildConfig.BASE_URL;
    public static final String interests_url = url + "Interests.php";

    Button next;
    RecyclerView recyclerView_horizontal,recyclerView_vert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests_screen);

        String [] arr = new String[]{"Arts","Music","Sports&Fitness","Technology","Language"};
//
//        for(int i=0;i<arr.length;i++)
//        {
//            Interest_category = arr[i];
//
//        }


        recyclerView_horizontal = findViewById(R.id.recycler_view_horizontal);
        recyclerView_horizontal.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
        recyclerView_horizontal.setLayoutManager(gridLayoutManager);
        Interest_Adapter categories = new Interest_Adapter(arr,this);
        recyclerView_horizontal.setAdapter(categories);

        String [] arr1 = new String[]{"sonu","sumit","lalu","sonu","sumit","lalu","sonu","sumit","lalu","sonu","sumit","lalu","sonu","sumit","lalu","sonu","sumit","lalu","sonu","sumit","lalu"};
        recyclerView_vert = findViewById(R.id.recycler_view_vertical);
        recyclerView_vert.setHasFixedSize(true);
        recyclerView_vert.setLayoutManager(new GridLayoutManager(this,2));
        Interest_Adapter sub_categories = new Interest_Adapter(arr1,this);
        recyclerView_vert.setAdapter(sub_categories);

        next = findViewById(R.id.intrest_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Interests_Screen.this,AvatarSelection_Screen.class);
                startActivity(intent);
            }
        });
    }

    void add_interests()
    {
        StringRequest request;
        request = new StringRequest(Request.Method.POST,
                interests_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //dialog.dismiss();
                if (response.equalsIgnoreCase("registered successfully")) {
                    Toast.makeText(Interests_Screen.this, "Done", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(Interests_Screen.this, response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //dialog.dismiss();
                Toast.makeText(Interests_Screen.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("category", Interest_category);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(Interests_Screen.this);
        requestQueue.add(request);
    }
}