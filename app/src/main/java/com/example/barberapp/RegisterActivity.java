package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.barberapp.requests.SingletonRequestQueue;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {




    private Button button;

    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        button.setOnClickListener(view -> {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, "",
                    response -> {

                    if(response != null && !response.equals("")){
                        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
                    }
            }, error -> {

            }
           ) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String,String> params=new HashMap<>();
                    params.put("username","");
                    params.put("password","");
                    return null;
                };

            };

            SingletonRequestQueue.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        });
    }
}
