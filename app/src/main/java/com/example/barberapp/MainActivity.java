package com.example.barberapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.barberapp.retrofit.TakeRdvActivity;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.plugins.annotation.OnSymbolClickListener;
import com.mapbox.mapboxsdk.plugins.annotation.Symbol;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mapbox.mapboxsdk.style.layers.Property.ICON_ROTATION_ALIGNMENT_VIEWPORT;

public class MainActivity extends AppCompatActivity {


    private MapView mapview;
    private Button sendCoor;

    @BindView(R.id.getSaloons)
    Button getSaloons;

    @BindView(R.id.registerButton)
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this,"pk.eyJ1IjoiaG91YmVueiIsImEiOiJjazQxNXEydjgwODdjM3BuOXVhcmJwc3dnIn0.R5DLYf2mxoAf8uVJk4zo_A");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sendCoor=findViewById(R.id.sendCoor);



        getSaloons.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),getSaloonsActivity.class);
            startActivity(intent);
        });

        register.setOnClickListener(view ->{

            Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
            startActivity(intent);

        });


        mapview=findViewById(R.id.mapView);
        mapview.onCreate(savedInstanceState);

        mapview.getMapAsync(mapboxMap -> mapboxMap.setStyle(Style.MAPBOX_STREETS, style -> {

            SymbolManager symbolManager =new SymbolManager(mapview,mapboxMap, style);

            symbolManager.addClickListener(symbol -> {

                 symbol = symbolManager.create(new SymbolOptions()
                        .withLatLng(new LatLng(60.169091, 24.939876)));
            });




            // set non-data-driven properties, such as:
            symbolManager.setIconAllowOverlap(true);
            symbolManager.setIconTranslate(new Float[]{-4f,5f});
            symbolManager.setIconRotationAlignment(ICON_ROTATION_ALIGNMENT_VIEWPORT);

        }));


        String url="http://192.168.43.210:8000/api/coor";
        sendCoor.setOnClickListener(view ->{
            StringRequest request =new StringRequest(StringRequest.Method.GET, url,response -> {

                if(response != null){

                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        int x= jsonObject.getInt("x");
                        int y= jsonObject.getInt("y");

                        Toast.makeText(getApplicationContext(),"x :"+x+",y :"+y,Toast.LENGTH_LONG).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }else {
                    Toast.makeText(getApplicationContext(),"Response is empty",Toast.LENGTH_LONG).show();
                }

            }, error -> {

                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            });

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(request);

        });

    }


    @OnClick(R.id.takeRdv)
    public void openPriseRdv(){
        Intent intent = new Intent(getApplicationContext(), TakeRdvActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mapview.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapview.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapview.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapview.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapview.onStart();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapview.onSaveInstanceState(outState);
    }


}