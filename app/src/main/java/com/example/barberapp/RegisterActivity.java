package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.barberapp.models.Saloon;
import com.example.barberapp.models.User;
import com.example.barberapp.retrofit.RegisterService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.acl.Owner;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.registerButton)
     Button register;

    private Gson gson;

    @BindView(R.id.usernameEdit)
    EditText username;

    @BindView(R.id.emailEdit)
    EditText emailEdit;

    @BindView(R.id.passwordEdit)
    EditText passwordEdit;

    @BindView(R.id.roleEdit)
    EditText roleEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        GsonBuilder builder =new GsonBuilder();
        gson=builder.create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.65:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        RegisterService registerService = retrofit.create(RegisterService.class);

        register.setOnClickListener(view -> {

            User user=new User();
            user.setUsername(username.getText().toString());
            user.setEmail(emailEdit.getText().toString());
            user.setPassword(passwordEdit.getText().toString());
            user.setRole(roleEdit.getText().toString());

            Log.i("YIY",
                    username.getText().toString() +
                    " "+emailEdit.getText().toString()+
                    " "+passwordEdit.getText().toString()+
                    " "+roleEdit.getText().toString());


            Map<String,String> params = new HashMap<>();
            params.put("username",user.getUsername());
            params.put("email",user.getEmail());
            params.put("password",user.getPassword());
            params.put("role",user.getRole());
            Call<String> sentUser =registerService.createUser(params);

            sentUser.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    String us =response.body();

                    if(us == null)
                        Toast.makeText(getApplicationContext(),response.toString() ,Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(),us ,Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                    call.cancel();
                    t.printStackTrace();
                }
            });
        });
    }
}
