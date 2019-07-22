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

        Call<List<Welcome>> call = api.getData();
            call.enqueue(new Callback<List<Welcome>>() {
            @Override
            public void onResponse(Call<List<Welcome>> call, Response<List<Welcome>> response) {

               //    if (!response.isSuccessful()) {
               //          textt.setText("Code: " + response.code());
              //          return;
         //   }

                List<Welcome> posts = response.body();
               for (Welcome project :posts) {
                    String content = "";
                    content += "ID: ";
                    content += "Title: ;"; //+ project.getSummary() + "\n";
                    content += "Description: "; //+ project.getDescription() + "\n";
                    textt.append(content);
                  }
            }

            @Override
            public void onFailure(Call<List<Welcome>> call, Throwable t) {
                    textt.setText(t.getMessage());
            }
        });



        }
    }




