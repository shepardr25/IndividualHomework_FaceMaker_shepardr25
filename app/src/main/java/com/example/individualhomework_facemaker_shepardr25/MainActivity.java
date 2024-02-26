package com.example.individualhomework_facemaker_shepardr25;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SeekBar;
import android.widget.TextView;

/*
 * @author Ruth Shepard
 */

public class MainActivity extends AppCompatActivity {
    private Face face;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Face View
        face = findViewById(R.id.surfaceView);

        //Initialize Random Button
        Button ranbutton = findViewById(R.id.ranbutton);

        //Initialize Text View for the Seek Bar Value Colors
        TextView redTextView = findViewById(R.id.rednum);
        TextView greenTextView = findViewById(R.id.greennum);
        TextView blueTextView = findViewById(R.id.bluenum);

        //Initialize Seek Bars
        SeekBar redSeekBar = findViewById(R.id.rseekbar);
        SeekBar greenSeekBar = findViewById(R.id.gseekbar);
        SeekBar blueSeekBar = findViewById(R.id.bseekbar);

        //Initialize spinner for hair style
        // Enables the four spinner options ("Lines", "Mowhawk", "Bangs", "Bald") for hairstyles in the layout
        Spinner hairSpinner = findViewById(R.id.hairspinner);
        String[] hairOptions = {"Lines", "Mowhawk", "Bangs", "Bald"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hairOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairSpinner.setAdapter(adapter);

        // Set listener for spinner to handle selection of different hairstyles
        hairSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedHairstyle = hairOptions[position];
                face.setHairstyle(selectedHairstyle);
                face.invalidate(); // To redraw the Face view
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        //Listener for the Random button
        EventHandler eventhandler = new EventHandler(redTextView, greenTextView, blueTextView);
        //EventHandler buttonevent = new EventHandler();
        ranbutton.setOnClickListener(eventhandler);

        //Listener for the Seek Bar Changes
        redSeekBar.setOnClickListener(eventhandler);
        greenSeekBar.setOnClickListener(eventhandler);
        blueSeekBar.setOnClickListener(eventhandler);
    }
}