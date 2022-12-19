package com.example.exercicecapteurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private ListView listView;
    private SensorManager sensorManager;
    private List<Sensor> sensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // get extra for intent
        String sensorName = getIntent().getStringExtra("sensor");

        // get list of sensors
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);


        // find the sensor
        for (Sensor sensor : sensorList) {
            if (sensor.getName().equals(sensorName)) {
                Log.d("Sensor", "Name: " + sensor.getName());
                Log.d("Sensor", "Type: " + sensor.getType());
                Log.d("Sensor", "Power: " + sensor.getPower());
                Log.d("Sensor", " ");
            }
        }

        listView = findViewById(R.id.sensorView);



    }
}