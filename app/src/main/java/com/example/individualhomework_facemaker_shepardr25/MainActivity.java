package com.example.individualhomework_facemaker_shepardr25;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SeekBar;
import android.widget.RadioButton;


/*
 * @author Ruth Shepard
 */

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback,
        SeekBar.OnSeekBarChangeListener, View.OnClickListener{
    private DrawFace billyBob;
    private Face face;
    public Spinner hairSpinner;
    public RadioButton radbuthair, radbutskin, radbuteyes;
    public SeekBar rseekbar, gseekbar, bseekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Face View
        billyBob = findViewById(R.id.surfaceView);
        face = billyBob.getFace();

        EventHandler event = new EventHandler(billyBob, this);
        event.updateColor();


        //Initialize Radio Buttons
        radbuthair = findViewById(R.id.radbuthair);
        radbuteyes = findViewById(R.id.radbuteyes);
        radbutskin = findViewById(R.id.radbutskin);

        //Initialize Seek Bars
        rseekbar = findViewById(R.id.rseekbar);
        gseekbar = findViewById(R.id.gseekbar);
        bseekbar = findViewById(R.id.bseekbar);

        //Initialize Random Button
        Button ranbutton = findViewById(R.id.ranbutton);

        //Initialize Spinner for Hairstyle
        // Enables the four spinner options ("Lines", "Mowhawk", "Bangs", "Bald") for hairstyles
        hairSpinner = findViewById(R.id.hairspinner);

        //Seek Bar On Click Listener
        rseekbar.setOnClickListener(event);
        gseekbar.setOnClickListener(event);
        bseekbar.setOnClickListener(event);

        //Radio Button  On Click Listener
        radbuthair.setOnClickListener(event);
        radbuteyes.setOnClickListener(event);
        radbutskin.setOnClickListener(event);

        //Random Button  On Click Listener
        ranbutton.setOnClickListener(event);

        //Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.hairarray,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairSpinner.setAdapter(adapter);
        hairSpinner.setOnItemSelectedListener(event);
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //Do Nothing
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        //Do Nothing
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //Do Nothing
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //Do Nothing
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Do Nothing
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Do Nothing
    }
    @Override
    public void onClick(View v) {
        billyBob.invalidate();
    }
}