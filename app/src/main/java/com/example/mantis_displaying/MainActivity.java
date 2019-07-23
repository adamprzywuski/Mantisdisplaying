package com.example.mantis_displaying;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.*;
import android.os.Bundle;
import android.widget.*;

import com.example.mantis_displaying.RetrofitClientInstance;
import com.example.mantis_displaying.example.Example;
import com.example.mantis_displaying.issues;
import com.example.mantis_displaying.Welcome.*;
import android.view.View;

import kotlin.jvm.Throws;
import retrofit2.Call;
import  retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.*;


public class MainActivity extends AppCompatActivity {

    ListView list;
    TextView textt;



    @Override
    protected void onCreate(Bundle savedInstanceState)    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView) findViewById(R.id.listt);
        textt=(TextView) findViewById(R.id.textView2);

        Retrofit retrofit=new Retrofit.Builder()
        .baseUrl(RetrofitClientInstance.API_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build();
        api api=retrofit.create(api.class);

        Call<List<win>> call = api.getData();
            call.enqueue(new Callback<List<win>>() {
            @Override
            public void onResponse(Call<List<win>> call, Response<List<win>> response) {

                  if (!response.isSuccessful()) {
                      textt.setText("Code: " + response.code());
                      return;
          }
                //must have
                List<win> posts = response.body();

                for (win project :posts) {
                    String content = "";
              //      content += "ID: "+posts.get(1).getIssues().get(1).getID()+"\n";
              //      content += "Title: ;"+posts.get(1).getIssues().get(1).getSummary()+"\n";
              //      content += "Description: "+posts.get(1).getIssues().get(1).getDescription()+"\n";
                    textt.append(content);

                  }
            }

            @Override
            public void onFailure(Call<List<win>> call, Throwable t) {
                    textt.setText(t.getMessage());
            }
        });



        }
    }




