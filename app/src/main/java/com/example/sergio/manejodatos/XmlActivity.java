package com.example.sergio.manejodatos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sergio.manejodatos.pojo.Plant;

import java.util.ArrayList;
import java.util.List;

public class XmlActivity extends AppCompatActivity {
    private ListView listView;
    List<Plant> plantList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        listView = findViewById(R.id.activity_xml_listview);

        PlantPullParser parser = new PlantPullParser();
        plantList = parser.parseXML(this);
        ArrayAdapter<Plant> adapter = new ArrayAdapter<Plant>(this,android.R.layout.simple_list_item_1,plantList);
        listView.setAdapter(adapter);
    }

}
