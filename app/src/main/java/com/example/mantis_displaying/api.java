package com.example.mantis_displaying;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Part;
import retrofit2.http.Path;


public interface api {


    @Headers("Authorization:Xdoyk8Pi3lmLuKjpAF6bk6tDHeMfXk36 ")
    @GET("/rest/issues?page_size=3&page=1")
    Call<List<projects>> getData();



}
