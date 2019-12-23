package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.barberapp.models.Saloon;
import com.example.barberapp.models.User;
import com.example.barberapp.retrofit.GetSaloonsService;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URLStreamHandler;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class getSaloonsActivity extends AppCompatActivity {

    @BindView(R.id.showOwnerButton)
    Button showOwnerButton;

    @BindView(R.id.showOwner)
    TextView showOwner;

    private Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_saloons);
        ButterKnife.bind(this);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.211:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        GetSaloonsService service = retrofit.create(GetSaloonsService.class);


        showOwnerButton.setOnClickListener(view -> {

            Call<List<User>> callOwners = service.listOwners();

            callOwners.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                    List<User> users = response.body();

                    for (User user : users){
                        Log.i("OOO","name :"+user.getEmail()+" "+user.getRole());
                    }

                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {

                    Log.i("OOO","Error");
                    call.cancel();
                }
            });

        });

    }
}
