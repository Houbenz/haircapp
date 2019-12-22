package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.barberapp.models.User;
import com.example.barberapp.requests.SingletonRequestQueue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;


public class RegisterActivity extends AppCompatActivity {



    @BindView(R.id.registerButton)
    private Button register;
    private Gson gson;

    String url = "http://192.168.42.143:8000/api/allSaloons";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        GsonBuilder builder =new GsonBuilder();
        gson=builder.create();


        register.setOnClickListener(view -> {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, "",
                    response -> {

                    if(response != null && !response.equals("")){
                       // User user=gson.fromJson(response,User.class);

                        //Toast.makeText(getApplicationContext(),"Hello :"+user.getEmail(),Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),"response : "+response,Toast.LENGTH_LONG).show();
                    }
            }, error -> {

            }
           )/* {
                @Override
                protected Map<String, String> getParams() {
                    Map<String,String> params=new HashMap<>();
                    params.put("username","");
                    params.put("password","");
                    return params;
                };

            }*/;

            SingletonRequestQueue.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        });
    }
}
