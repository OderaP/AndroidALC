package com.example.memorableplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    static ArrayList<String> places = new ArrayList<>();
    static ArrayList<LatLng> locations = new ArrayList<>();
    static ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);


        places.add("Add a new place..");
        locations.add(new LatLng(0, 0));
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, places);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("placeNumber ", i);
                startActivity(intent);
            }
        });
    }
}
