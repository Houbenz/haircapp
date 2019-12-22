package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.barberapp.models.Saloon;
import com.example.barberapp.models.User;
import com.example.barberapp.requests.SingletonRequestQueue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.acl.Owner;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RegisterActivity extends AppCompatActivity {



    @BindView(R.id.registerButton)
     Button register;

    @BindView(R.id.showOwner)
    TextView showOwner;

    private Gson gson;



    String url = "http://192.168.43.143:8000/api/allSaloons";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        GsonBuilder builder =new GsonBuilder();
        gson=builder.create();


        register.setOnClickListener(view -> {

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    response -> {

                    if(response != null && !response.equals("")){
                        Saloon saloon=gson.fromJson(response, Saloon.class);

                        //Toast.makeText(getApplicationContext(),"Hello :"+user.getEmail(),Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),"response : "+response,Toast.LENGTH_LONG).show();
                        showOwner.setText("name :"+saloon.getName()+"\n"
                        +"description"+saloon.getDescription());
                    }
            }, error -> {

                Toast.makeText(getApplicationContext(),"error : "+error.getMessage(),Toast.LENGTH_LONG).show();
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

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
            // SingletonRequestQueue.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        });
    }
}
