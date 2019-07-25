package com.example.mantis_displaying;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    datacollector ds=new datacollector();
    ArrayList<String> buffor = new ArrayList<String>();
    ArrayList<String> titles=new ArrayList<>();
    ArrayList<String> descprit=new ArrayList<>();
    ArrayList<ArrayList<String>> comments=new ArrayList<>();
    TextView title,description;
    EditText write;
    int position;
    Button btn,button;
    ListView list2;

    private void settingAdapter2(ArrayList<ArrayList<String>>k,ListView we,int position)
    {
        ArrayList<String> qwe= k.get(position);
        we.setAdapter(new ArrayAdapter<String>(this, R.layout.listexample, R.id.Row, qwe));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Gson gson = new Gson();
        datacollector ob = gson.fromJson(getIntent().getStringExtra("4"), datacollector.class);
        buffor=ob.buffor;
        titles=ob.titles;
        descprit=ob.descprit;
        position=ob.positions;
        comments=ob.comments;
        //initialize the layout variable
        Button clickButton = (Button) findViewById(R.id.back);
        title=findViewById(R.id.Title);
        description=findViewById(R.id.textView3);
        list2=findViewById(R.id.messages_view);

        //displaying the info in the specyfic places
        title.setText(titles.get(position));
        //    title.setBackgroundColor(Integer.valueOf(color.get(position)));
       // descprit.get(position).replace("\n"," ");
        description.setText(descprit.get(position));
        settingAdapter2(comments,list2,position);

    }
}
