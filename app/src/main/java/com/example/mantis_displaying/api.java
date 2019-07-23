package com.example.mantis_displaying;



import retrofit2.Call;

import retrofit2.http.GET;

import retrofit2.http.Headers;


public interface api {


    @Headers("Authorization:hV6kKJZA5VN-ZsfP2teVpxvw833bpLGh")
    @GET("/api/rest/issues?page_size=10&page=1")
    Call<Issues> getData();


 //   @Headers("Authorization:hV6kKJZA5VN-ZsfP2teVpxvw833bpLGh")
  //  @GET("/api/rest/issues?page_size=10&page=1")
   // Call<win> getAllIssues();







}
