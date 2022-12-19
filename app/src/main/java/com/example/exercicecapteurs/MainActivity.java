package com.example.exercicecapteurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private List<Sensor> sensorList;
    private List<String> sensorListName;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        sensorListName = new ArrayList<>();

        // fill the listView with the sensors
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensorList) {
            sensorListName.add(sensor.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sensorListName);
        listView.setAdapter(adapter);


        /*
        // display all sensors
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        Log.d("MainActivity", "Number of sensors: " + sensorList.size());
        for (Sensor sensor : sensorList) {
            Log.d("Sensor", "Name: " + sensor.getName());
            Log.d("Sensor", "Type: " + sensor.getType());
            Log.d("Sensor", "Power: " + sensor.getPower());
            Log.d("Sensor", " ");
        }
           */


        // listener for the listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Log.d("MainActivity", "Position: " + position);
               // Log.d("MainActivity", "Sensor: " + sensorList.get(position).getName());

                // start new intent for the details
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("sensor", sensorListName.get(position));
                startActivity(intent);
            }
        });


    }
}