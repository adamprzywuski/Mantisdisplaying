package com.example.mantis_displaying;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.*;
import retrofit2.http.GET;

public interface api<Get_all_projects> {
    Retrofit retrofit=new Retrofit.Builder()
    .baseUrl("https://mantis.mobilebox.pl/")
     .build();


    api service=retrofit.create(MainActivity.class);


    @GET("api/rest/projects")
    Call<projects>getList(@Header("Authorization: Xdoyk8Pi3lmLuKjpAF6bk6tDHeMfXk36")String authorization );


}
