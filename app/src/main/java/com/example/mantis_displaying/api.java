package com.example.mantis_displaying;



import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;

import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface api {
//Interefence where are Http function

    @Headers("Authorization:hV6kKJZA5VN-ZsfP2teVpxvw833bpLGh")
    @GET("/api/rest/issues?page_size=10&page=1")
    Call<Issues> getData();


 //   @Headers("Authorization:hV6kKJZA5VN-ZsfP2teVpxvw833bpLGh")
  //  @GET("/api/rest/issues?page_size=10&page=1")
   // Call<win> getAllIssues();


    @Headers({"Authorization:hV6kKJZA5VN-ZsfP2teVpxvw833bpLGh",
            "Content-Type: application/json"})
   @POST("/api/rest/issues/{issue_id}/notes")
    Call<sending>sendNotes(
            @Path("issue_id") int id,
                            @Body sending body);



    @Headers("Authorization:hV6kKJZA5VN-ZsfP2teVpxvw833bpLGh")
    @GET("/api/rest/issues/{issue_id}")
    Call<Issues> getIssues(
            @Path("issue_id") int id
    );


    @Headers("Authorization:hV6kKJZA5VN-ZsfP2teVpxvw833bpLGh")
    @GET("/api/rest/issues?page_size=30&page=1")
    Call<Issues> getDatas();









}
