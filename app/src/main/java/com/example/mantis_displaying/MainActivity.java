package com.example.mantis_displaying;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.*;
import java.util.jar.JarEntry;
import android.os.StrictMode;
import android.os.Bundle;
import android.widget.*;
import retrofit2.Call;
import  retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import android.os.NetworkOnMainThreadException;

import android.widget.Toast;
import android.view.*;
import retrofit2.*;


public class MainActivity extends AppCompatActivity  {

    ListView list;
    TextView textt;




    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView) findViewById(R.id.listt);
        textt=(TextView) findViewById(R.id.textView2);

        Retrofit retrofit=new Retrofit.Builder()
        .baseUrl(RetrofitClientInstance.API_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build();
        api api=retrofit.create(api.class);

        Call<List<projects>> call = api.getData();
        call.enqueue(new Callback<List<projects>>() {
            @Override
            public void onResponse(Call<List<projects>> call, Response<List<projects>> response) {
                try {
                    List<projects> contributors = call.execute().body();
                    for (projects contributor : contributors) {
                        String wynik="";
                        wynik+=contributor.name + " (" + String.valueOf(contributor.getId()) + ")" + contributor.getDescirption();
                        textt.setText(wynik);   }
                }catch(IOException e)
                {}

            }

            @Override
            public void onFailure(Call<List<projects>> call, Throwable t) {
                    textt.setText("Failure");
            }
        });



        }
    }




