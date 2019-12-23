package com.example.barberapp.retrofit;

import com.example.barberapp.models.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegisterService {


    @FormUrlEncoded
    @POST("register")
    Call<String> createUser(@FieldMap Map<String,String> params);
}
