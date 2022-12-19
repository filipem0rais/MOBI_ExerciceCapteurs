package com.example.exercicecapteurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // display all sensors
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        Log.d("MainActivity", "Number of sensors: " + sensorList.size());
        for (Sensor sensor : sensorList) {
            Log.d("Sensor", "Name: " + sensor.getName());
            Log.d("Sensor", "Type: " + sensor.getType());
            Log.d("Sensor", "Power: " + sensor.getPower());
            Log.d("Sensor", " ");
        }
    }
}