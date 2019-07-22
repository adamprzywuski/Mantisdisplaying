package com.example.mantis_displaying;

import com.example.mantis_displaying.example.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

import retrofit2.http.GET;

import retrofit2.http.Headers;
import retrofit2.http.Part;




public interface api {


    @Headers("Authorization:hV6kKJZA5VN-ZsfP2teVpxvw833bpLGh")
    @GET("/api/rest/issues?page_size=10&page=1")
    Call<List<Example>> getData();



}
