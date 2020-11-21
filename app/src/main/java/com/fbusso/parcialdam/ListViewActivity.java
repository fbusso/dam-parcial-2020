package com.fbusso.parcialdam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView list = findViewById(R.id.list_view_activity_list);

        CustomDbHelper db = new CustomDbHelper(this);
        ArrayList<String> customList = new ArrayList<String>(db.getAllCustomEntities());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, customList);
        list.setAdapter(arrayAdapter);


    }

}