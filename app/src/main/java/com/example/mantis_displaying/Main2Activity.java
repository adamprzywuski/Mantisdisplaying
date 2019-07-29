package com.example.mantis_displaying;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.CheckBox;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {
    //creating variables for date
    datacollector ds=new datacollector();
    ArrayList<String> buffor = new ArrayList<String>();
    ArrayList<String> titles=new ArrayList<>();
    ArrayList<String> descprit=new ArrayList<>();
    ArrayList<ArrayList<String>> comments=new ArrayList<>();
    ArrayList<Integer> ID=new ArrayList<>();
    ArrayAdapter<String> adapter;
    TextView title,description;

//creating variebles for layout
    EditText write;
    int position;
    ImageButton btn;
    ListView list2;
    CheckBox check;
    sending send=new sending();
//function which put data into the ListView
    private void settingAdapter2(ArrayList<ArrayList<String>>k,ListView we,int position)
    {
        ArrayList<String> qwe= k.get(position);
        adapter=new ArrayAdapter<String>(this, R.layout.listexample, R.id.Row, qwe);
        we.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //getting date from previously activities and initiliaze variables
        Gson gson = new Gson();
        datacollector ob = gson.fromJson(getIntent().getStringExtra("4"), datacollector.class);
        buffor=ob.buffor;
        titles=ob.titles;
        descprit=ob.descprit;
        position=ob.positions;
        comments=ob.comments;

        ID=ob.ID;

        //initialize the layout variable
        Button clickButton = (Button) findViewById(R.id.back);
        title=findViewById(R.id.Title);
        description=findViewById(R.id.textView3);
        list2=findViewById(R.id.messages_view);
        write=findViewById(R.id.editText);
        btn=findViewById(R.id.button);
        check=findViewById(R.id.checkBox);

        //displaying the info in the specyfic places
        title.setText(titles.get(position));
        description.setText(descprit.get(position));
        settingAdapter2(comments,list2,position);

        //when button to accept messeges will be click
        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Getting data from the EditText

                //When the user click the button it disappear the keyboard
                write.setInputType(InputType.TYPE_NULL);
                send.setText(write.getText().toString());
                write.setText("");
                if(check.isChecked())
                {
                    view_state view=new view_state("private");

                    send.setView_state(view);
                }
                else
                {
                    view_state view=new view_state("public");

                    send.setView_state(view);
                }

                //initilize RETROFIT
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(RetrofitClientInstance.API_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                final api apiPost = retrofit.create(api.class);

                Call<sending> call = apiPost.sendNotes(ID.get(position),send);
                call.enqueue(new Callback<sending>() {
                    @Override
                    public void onResponse(Call<sending> call, Response<sending> response) {

                        //if some HTTP code response
                        if (!response.isSuccessful()) {
                            description.setText("Code: " + response.code());
                            return;
                        }
                            Call<Issues> callx=apiPost.getIssues(ID.get(position));
                            callx.enqueue(new Callback<Issues>() {
                                @Override
                                public void onResponse(Call<Issues> call, Response<Issues> response) {
                                    if (!response.isSuccessful()) {
                                        description.setText("Code: " + response.code());
                                        return;
                                    }
                                    Issues posts = response.body();

                                    for (date project : posts.getIssues()) {
                                        ArrayList<String>qwe=new ArrayList<String>();
                                        int i=-1;
                                        for (comments note : project.getNotes()) {
                                            i++;
                                            String help = "";
                                            help += note.reporter.name + "  " + note.created_at + "\n";

                                            //Adding to comments if issue is private
                                            if(!note.view_state.name.equals("public"))
                                            {
                                                help+="[private]"+"\n";
                                            }
                                            help += note.text + "\n";

                                            qwe.add(help);

             }
                                        comments.set(position,qwe);
                                        settingAdapter2(comments,list2,position);

                                    }

                                }


                                @Override
                                public void onFailure(Call<Issues> call, Throwable t) {

                                }
                            });




                    }

                    @Override
                    public void onFailure(Call<sending> call, Throwable t) {
                        description.setText(t.getMessage());
                    }


        });

    }
});


    }


}


