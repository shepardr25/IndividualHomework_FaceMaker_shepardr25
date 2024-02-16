package com.example.individualhomework_facemaker_shepardr25;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/*
 * @author Ruth Shepard
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enables the four spinner options (curly, straight, bangs, messy) for hairstyles in the layout
        Spinner hairSpinner = findViewById(R.id.hairSpinner);
        String[] hairOptions = {"Curly", "Straight", "Bangs", "Messy"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hairOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairSpinner.setAdapter(adapter);
    }
}