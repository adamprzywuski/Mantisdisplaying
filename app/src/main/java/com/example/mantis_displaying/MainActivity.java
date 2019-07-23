package com.example.mantis_displaying;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import java.lang.String;

import java.util.ArrayList;

import retrofit2.Call;
import  retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.*;


public class MainActivity extends AppCompatActivity {
//creating variables to layout
    ListView list;
    TextView textt;
    private ArrayAdapter<String> adapter ;
    String countryList[] = {"India \n i tak sobie pisze dalej", "China", "australia", "Portugle", "America", "NewZealand"};

    ArrayList<String> buffor=new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState)    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initiliaze variables to layout
        list=(ListView) findViewById(R.id.listt);
        textt=findViewById(R.id.textView);
        textt.setText("");
        Retrofit retrofit=new Retrofit.Builder()
        .baseUrl(RetrofitClientInstance.API_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build();
        api api=retrofit.create(api.class);

        Call<Issues> call = api.getData();
            call.enqueue(new Callback<Issues>() {
            @Override
            public void onResponse(Call<Issues> call, Response<Issues> response) {

                  if (!response.isSuccessful()) {
                      textt.setText("Code: " + response.code());
                      return;
          }

                //absorbing JSON as object my class
                    Issues posts=response.body();
                  //creating a cointener which will be displaying the data
                        int i=0;
                        for(date project:posts.getIssues())
                        {
                            String storage="";
                            storage+="ID: "+Integer.toString(project.id)+"\n";
                            storage+="Summary: "+project.summary+"\n";
                            storage+="Descpription: "+project.description+"\n"+"\n";
                            textt.setText(textt.getText()+storage);
                            buffor.add(storage);
                          //  exe[i]=storage;
                        i++;
                        }
              //   adapter=new ArrayAdapter<String>(this,R.layout.listexample,R.id.Row,countryList);
                list.setAdapter(adapter);



            }

            @Override
            public void onFailure(Call<Issues> call, Throwable t) {
                   textt.setText("Error"+t.getMessage());
            }
        });


     //   adapter = new ArrayAdapter<String>(this,R.layout.listexample,R.id.Row,exe);




        }
    }




