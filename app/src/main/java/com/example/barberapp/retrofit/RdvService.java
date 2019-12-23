package com.example.barberapp.retrofit;

import com.example.barberapp.models.Rdv;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RdvService {


    @FormUrlEncoded
    @POST
    Call<Rdv> prendreRdv(@FieldMap Map<String,String> params);
}
