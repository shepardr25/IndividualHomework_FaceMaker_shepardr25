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

        EventHandler eventHandler = new EventHandler(billyBob, this);
        eventHandler.updateColor();

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
        hairSpinner = findViewById(R.id.hairspinner);

        // Set event listeners
        rseekbar.setOnSeekBarChangeListener(eventHandler);
        gseekbar.setOnSeekBarChangeListener(eventHandler);
        bseekbar.setOnSeekBarChangeListener(eventHandler);
        radbuthair.setOnClickListener(eventHandler);
        radbuteyes.setOnClickListener(eventHandler);
        radbutskin.setOnClickListener(eventHandler);
        ranbutton.setOnClickListener(eventHandler);
        hairSpinner.setOnItemSelectedListener(eventHandler);

        // Set adapter for the hairSpinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.hairarray,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairSpinner.setAdapter(adapter);
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