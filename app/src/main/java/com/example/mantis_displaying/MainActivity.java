package com.example.mantis_displaying;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.widget.ListView;
import android.widget.*;
import android.os.Bundle;
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
    ListView list;
    TextView textt;
    int how_many = 1;
    Button update;
    private ArrayAdapter<String> adapter;
    int posititions;
    ArrayList<String> buffor = new ArrayList<String>();
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> descprit = new ArrayList<>();
    ArrayList<ArrayList<String>> comments = new ArrayList<>();
    //   ArrayList<String> color=new ArrayList<>();
    ArrayList<Integer> ID = new ArrayList<>();
    boolean refresh=false;


    //function for displaying the Listview
    private void settingAdapter(ArrayList<String> k, ListView we) {


        k.add("-------------------------------------------View more Issues-------------------------------------------" + "\n");
        adapter = new ArrayAdapter<String>(this, R.layout.listexample, R.id.Row, k);
        we.setAdapter(adapter);
    }

    private void updating_date()
    {
        buffor.clear();
        titles.clear();
        descprit.clear();
        comments.clear();
        ID.clear();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClientInstance.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api apix = retrofit.create(api.class);
        Call<Issues> callx = apix.getDatas(10 * how_many);
        callx.enqueue(new Callback<Issues>() {
            @Override
            public void onResponse(Call<Issues> call, Response<Issues> response) {
                how_many++;
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
                    String storage2 = "";
                    storage += "ID: " + Integer.toString(project.id) + "\n";
                    storage += "Projekt:" + project.project.name + "\n";
                    storage += "Nazwa: " + project.summary + "\n";
                    storage += "Opis: " + project.description + "\n" + "\n";
                    buffor.add(storage);
                    ID.add(project.id);

                    //date for the next layout
                    storage2 += project.project.name + "\n";
                    storage2 += project.summary;
                    titles.add(storage2);
                    storage2 = "";
                    storage2 += "Data: " + project.created_at + "\n";
                    storage2 += "Twórca zgłoszenia: " + project.reporter.name + "\n";
                    storage2 += "Opis: " + project.description + "\n";
                    descprit.add(storage2);


                    ArrayList<String> qwe = new ArrayList<String>();
                    if (project.getNotes() != null) {
                        for (comments note : project.getNotes()) {
                            String help = "";
                            help += note.reporter.name + "  " + note.created_at + "\n";

                            //Adding to comments if issue is private
                            if (!note.view_state.name.equals("public")) {
                                help += "[private]" + "\n";
                            }
                            help += note.text + "\n";
                            qwe.add(help);
                        }

                    }
                    //IF USER DOESN'T CLICK THE LAST BUTTON
                    else {
                        storage = "No comments detected";
                        qwe.add(storage);
                    }
                    comments.add(qwe);
                }
                //using function which displaying the list with data which are in bufor

                //  settingAdapter(buffor,list);
                buffor.add("-------------------------------------------View more Issues-------------------------------------------" + "\n");
                adapter.notifyDataSetChanged();





            }

            @Override
            public void onFailure(Call<Issues> call, Throwable t) {
                textt.setText("Error" + t.getMessage());
            }
        });


    }


    //function to sending and changing activities
    private void newIntern(int positions) {
        Gson gson = new Gson();

        Intent intent = new Intent(this, Main2Activity.class);
        datacollector ds = new datacollector();
        ds.buffor = buffor;
        ds.comments = comments;
        ds.descprit = descprit;
        ds.titles = titles;
        ds.positions = posititions;
        ds.ID = ID;
        String myJson = gson.toJson(ds);
        intent.putExtra("4", myJson);

        startActivity(intent);

    }

    //function on start
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);


        //initiliaze variables to layout
        list = (ListView) findViewById(R.id.listt);
        textt = findViewById(R.id.textView2);
        textt.setText("");
        update = findViewById(R.id.update);


        //initilize RETROFIT
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClientInstance.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api api = retrofit.create(api.class);
        how_many++;
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
                //creating a container which will be displaying the data
                for (date project : posts.getIssues()) {

                    //date for the first layout
                    String storage = "";
                    String storage2 = "";
                    storage += "ID: " + Integer.toString(project.id) + "\n";
                    storage += "Projekt:" + project.project.name + "\n";
                    storage += "Nazwa: " + project.summary + "\n";
                    storage += "Opis: " + project.description + "\n" + "\n";
                    buffor.add(storage);
                    ID.add(project.id);

                    //date for the next layout
                    storage2 += project.project.name + "\n";
                    storage2 += project.summary;
                    titles.add(storage2);
                    storage2 = "";
                    storage2 += "Data: " + project.created_at + "\n";
                    storage2 += "Twórca zgłoszenia: " + project.reporter.name + "\n";
                    storage2 += "Opis: " + project.description + "\n";
                    descprit.add(storage2);
                    //iteration for getting comments to String
                    ArrayList<String> qwe = new ArrayList<String>();
                    if (project.getNotes() != null) {
                        for (comments note : project.getNotes()) {
                            String help = "";
                            help += note.reporter.name + "  " + note.created_at + "\n";
                            //Adding to comments if issue is private
                            if (!note.view_state.name.equals("public")) {
                                help += "[private]" + "\n";
                            }
                            help += note.text + "\n";
                            qwe.add(help);

                        }

                    } else {
                        storage = "No comments detected";
                        qwe.add(storage);
                    }
                    comments.add(qwe);

                }
                //using function which displaying the list with data which are in bufor
                settingAdapter(buffor, list);


            }

            @Override
            public void onFailure(Call<Issues> call, Throwable t) {
                textt.setText("Error" + t.getMessage());
            }
        });
//////TODO THERE WILL BE NEXT PART...

        // Set an item click listener for ListView
        //That's mean its allows to display more details
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    //if user click the last button it should display more ISSUES
                    //***IN PROGRESS***
                    if (buffor.size() - 1 == position) {

                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(RetrofitClientInstance.API_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        api apix = retrofit.create(api.class);
                        Call<Issues> callx = apix.getDatas(10 * how_many);
                        callx.enqueue(new Callback<Issues>() {
                            @Override
                            public void onResponse(Call<Issues> call, Response<Issues> response) {
                                how_many++;
                                if (!response.isSuccessful()) {
                                    textt.setText("Code: " + response.code());
                                    return;
                                }
                                buffor.clear();
                                titles.clear();
                                descprit.clear();
                                comments.clear();
                                ID.clear();

                                //absorbing JSON as object my class
                                Issues posts = response.body();
                                //creating a cointener which will be displaying the data
                                for (date project : posts.getIssues()) {

                                    //date for the first layout
                                    String storage = "";
                                    String storage2 = "";
                                    storage += "ID: " + Integer.toString(project.id) + "\n";
                                    storage += "Projekt:" + project.project.name + "\n";
                                    storage += "Nazwa: " + project.summary + "\n";
                                    storage += "Opis: " + project.description + "\n" + "\n";
                                    buffor.add(storage);
                                    ID.add(project.id);

                                    //date for the next layout
                                    storage2 += project.project.name + "\n";
                                    storage2 += project.summary;
                                    titles.add(storage2);
                                    storage2 = "";
                                    storage2 += "Data: " + project.created_at + "\n";
                                    storage2 += "Twórca zgłoszenia: " + project.reporter.name + "\n";
                                    storage2 += "Opis: " + project.description + "\n";
                                    descprit.add(storage2);


                                    ArrayList<String> qwe = new ArrayList<String>();
                                    if (project.getNotes() != null) {
                                        for (comments note : project.getNotes()) {
                                            String help = "";
                                            help += note.reporter.name + "  " + note.created_at + "\n";

                                            //Adding to comments if issue is private
                                            if (!note.view_state.name.equals("public")) {
                                                help += "[private]" + "\n";
                                            }
                                            help += note.text + "\n";
                                            qwe.add(help);
                                        }

                                    }
                                    //IF USER DOESN'T CLICK THE LAST BUTTON
                                    else {
                                        storage = "No comments detected";
                                        qwe.add(storage);
                                    }
                                    comments.add(qwe);
                                }
                                //using function which displaying the list with data which are in bufor

                                //  settingAdapter(buffor,list);
                                buffor.add("-------------------------------------------View more Issues-------------------------------------------" + "\n");
                                adapter.notifyDataSetChanged();





                            }

                            @Override
                            public void onFailure(Call<Issues> call, Throwable t) {
                                textt.setText("Error" + t.getMessage());
                            }
                        });
                    } else {
                        posititions = position;
                        newIntern(position);
                    }


                }
            });
            update.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {


                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(RetrofitClientInstance.API_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        api apix = retrofit.create(api.class);
                        Call<Issues> callx = apix.getDatas(10 * (how_many-1));
                        callx.enqueue(new Callback<Issues>() {
                            @Override
                            public void onResponse(Call<Issues> call, Response<Issues> response) {
                                how_many++;
                                if (!response.isSuccessful()) {
                                    textt.setText("Code: " + response.code());
                                    return;
                                }
                                // updating_date();
                                buffor.clear();
                                titles.clear();
                                descprit.clear();
                                comments.clear();
                                ID.clear();

                                //absorbing JSON as object my class
                                Issues posts = response.body();
                                //creating a cointener which will be displaying the data
                                for (date project : posts.getIssues()) {

                                    //date for the first layout
                                    String storage = "";
                                    String storage2 = "";
                                    storage += "ID: " + Integer.toString(project.id) + "\n";
                                    storage += "Projekt:" + project.project.name + "\n";
                                    storage += "Nazwa: " + project.summary + "\n";
                                    storage += "Opis: " + project.description + "\n" + "\n";
                                    buffor.add(storage);
                                    ID.add(project.id);

                                    //date for the next layout
                                    storage2 += project.project.name + "\n";
                                    storage2 += project.summary;
                                    titles.add(storage2);
                                    storage2 = "";
                                    storage2 += "Data: " + project.created_at + "\n";
                                    storage2 += "Twórca zgłoszenia: " + project.reporter.name + "\n";
                                    storage2 += "Opis: " + project.description + "\n";
                                    descprit.add(storage2);


                                    ArrayList<String> qwe = new ArrayList<String>();
                                    if (project.getNotes() != null) {
                                        for (comments note : project.getNotes()) {
                                            String help = "";
                                            help += note.reporter.name + "  " + note.created_at + "\n";

                                            //Adding to comments if issue is private
                                            if (!note.view_state.name.equals("public")) {
                                                help += "[private]" + "\n";
                                            }
                                            help += note.text + "\n";
                                            qwe.add(help);
                                        }

                                    }
                                    //IF USER DOESN'T CLICK THE LAST BUTTON
                                    else {
                                        storage = "No comments detected";
                                        qwe.add(storage);
                                    }
                                    comments.add(qwe);
                                    refresh=false;
                                }
                                //using function which displaying the list with data which are in bufor

                                //  settingAdapter(buffor,list);
                                buffor.add("-------------------------------------------View more Issues-------------------------------------------" + "\n");
                                adapter.notifyDataSetChanged();


                            }

                            @Override
                            public void onFailure(Call<Issues> call, Throwable t) {
                                textt.setText("Error" + t.getMessage());
                            }
                        });
                    }

            });

        }

    }



