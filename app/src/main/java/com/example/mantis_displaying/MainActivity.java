package com.example.mantis_displaying;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ListView;
import android.widget.*;
import android.os.Bundle;
import android.widget.*;
import java.lang.String;
import android.view.*;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import  retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.*;


public class MainActivity extends AppCompatActivity {
    //creating variables to layout
    ListView list,list2;
    TextView textt;
    TextView title,description;
    EditText write;
    Button btn,button;
    private ArrayAdapter<String> adapter;
    int posititions;

    ArrayList<String> buffor = new ArrayList<String>();
    ArrayList<String> titles=new ArrayList<>();
    ArrayList<String> descprit=new ArrayList<>();
    ArrayList<ArrayList<String>> comments=new ArrayList<>();
    ArrayList<String> color=new ArrayList<>();

    private void settingAdapter(ArrayList<String> k,ListView we) {
        we.setAdapter(new ArrayAdapter<String>(this, R.layout.listexample, R.id.Row, k));
    }

    private void newIntern(int position)
    {
        Gson gson=new Gson();

        Intent intent = new Intent(this,  Main2Activity.class);
        datacollector ds=new datacollector();
        ds.buffor=buffor;
        ds.comments=comments;
        ds.descprit=descprit;
        ds.titles=titles;
        ds.positions=posititions;
        String myJson=gson.toJson(ds);
        intent.putExtra("4",myJson);

        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initiliaze variables to layout
        list = (ListView) findViewById(R.id.listt);
        textt = findViewById(R.id.textView2);
        textt.setText("");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClientInstance.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api api = retrofit.create(api.class);

        Call<Issues> call = api.getData();
        call.enqueue(new Callback<Issues>() {
            @Override
            public void onResponse(Call<Issues> call, Response<Issues> response) {

                if (!response.isSuccessful()) {
                    textt.setText("Code: " + response.code());
                    return;
                }

                //absorbing JSON as object my class
                Issues posts = response.body();
                //creating a cointener which will be displaying the data
                for (date project : posts.getIssues()) {

                    //date for the first layout
                    String storage = "";
                    String storage2="";
                    storage += "ID: " + Integer.toString(project.id) + "\n";
                    storage+="Projekt:"+project.project.name+"\n";
                    storage += "Nazwa: " + project.summary + "\n";
                    storage += "Opis: " + project.description + "\n" + "\n";
                    buffor.add(storage);

                    //date for the next layout
                    storage2+=project.project.name+"\n";
                    storage2+=project.summary;
                    titles.add(storage2);
                    storage2="";
                    storage2+=" Data: "+project.created_at+"\n";
                    storage2+=" Twórca zgłoszenia: "+project.reporter.name+"\n";
                    storage2+=" Opis: "+project.description+"\n";
                    descprit.add(storage2);
                  //  color.add(project.new_values.getColor());
                    ArrayList<String>qwe=new ArrayList<String>();
                    if(project.getNotes()!=null) {
                        for (comments note : project.getNotes()) {
                            String help = "";
                            help += note.reporter.name + "  " + note.created_at + "\n";
                            help += note.text + "\n";
                            qwe.add(help);
                        }

                    }
                    else
                    {
                        storage="No comments detected";
                        qwe.add(storage);
                    }
                    comments.add(qwe);
                }
                //using function which displaying the list with data which are in bufor
                settingAdapter(buffor,list);


            }

            @Override
            public void onFailure(Call<Issues> call, Throwable t) {
                textt.setText("Error" + t.getMessage());
            }
        });


        // Set an item click listener for ListView
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            posititions=position;
            newIntern(position);







            }
        });


    }

}
