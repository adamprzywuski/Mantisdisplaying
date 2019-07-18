package com.example.mantis_displaying;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.os.Bundle;
import android.widget.*;
import retrofit2.*;
import android.view.*;


public class MainActivity extends AppCompatActivity implements api {

    ListView list;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView) findViewById(R.id.listt);
    }


}
