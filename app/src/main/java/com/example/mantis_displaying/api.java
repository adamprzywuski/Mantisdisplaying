package com.example.mantis_displaying;



import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;

import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface api {
//Interefence where are Http function

    @Headers("Authorization:{WRITE_YOURS_TOKEN}")
    @GET("/api/rest/issues?page_size=10&page=1")
    Call<Issues> getData();



    @Headers({"Authorization:{WRITE_YOURS_TOKEN}",
            "Content-Type: application/json"})
   @POST("/api/rest/issues/{issue_id}/notes")
    Call<sending>sendNotes(
            @Path("issue_id") int id,
                            @Body sending body);



    @Headers("Authorization:{WRITE_YOURS_TOKEN}")
    @GET("/api/rest/issues/{issue_id}")
    Call<Issues> getIssues(
            @Path("issue_id") int id
    );


    @Headers("Authorization:{WRITE_YOURS_TOKEN}")
    @GET("/api/rest/issues?page_size=10&page=1")
    Call<Issues> getDatas(@Query("page") int id);









}
