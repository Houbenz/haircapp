package com.example.barberapp.retrofit;

import com.example.barberapp.models.Saloon;
import com.example.barberapp.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetSaloonsService {


    @GET("allSaloons")
    Call<List<User>> listOwners();
}
