package com.example.individualhomework_facemaker_shepardr25;

import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.app.Activity;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import static android.graphics.Color.rgb;

public class EventHandler implements View.OnClickListener, View.OnTouchListener,
        SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener,
        AdapterView.OnItemSelectedListener {
    private DrawFace facePict;
    private Face face;
    private TextView redTextView, greenTextView, blueTextView;
    private SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    private int rVal, gVal, bVal;

    public EventHandler(DrawFace initFaceView, Activity myActivity) {
        facePict = initFaceView;
        face = facePict.getFace();
        redTextView = myActivity.findViewById(R.id.redseektitle);
        greenTextView = myActivity.findViewById(R.id.greenseektitle);
        blueTextView = myActivity.findViewById(R.id.blueseektitle);
    }

    @Override
    public void onClick(View view) {
        redSeekBar = facePict.findViewById(R.id.rseekbar);
        greenSeekBar = facePict.findViewById(R.id.gseekbar);
        blueSeekBar = facePict.findViewById(R.id.bseekbar);

        if(view.getId() == R.id.radbuthair) {
            face.selected = R.id.radbuthair;
        } else if(view.getId() == R.id.radbutskin) {
            face.selected = R.id.radbutskin;
        } else if(view.getId() == R.id.radbuteyes) {
            face.selected = R.id.radbuteyes;
        }

        // Button Click Handler
        if (view.getId() == R.id.ranbutton) {
            face.randomize();
            this.updateColor();

        }
        facePict.invalidate();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        //Do Nothing
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (b) {
            int color = rgb(face.red, face.green, face.blue);
            if (seekBar.getId() == R.id.rseekbar) {
                face.red = i;
            } else if (seekBar.getId() == R.id.gseekbar) {
                face.green = i;
            } else if (seekBar.getId() == R.id.bseekbar) {
                face.blue = i;
            }
            if (face.selected == R.id.radbuthair) {
                face.setHairColor(color);
            } else if (face.selected == R.id.radbutskin) {
                face.setSkinTone(color);
            } else if (face.selected == R.id.radbuteyes) {
                face.setEyeColor(color);
            }
            updateColor();
            facePict.invalidate();
        }

    }

    public void updateColor(){
        if(face.selected == R.id.radbuthair) {
            this.redTextView.setText("" + face.hRed);
            this.greenTextView.setText("" + face.hGreen);
            this.blueTextView.setText("" + face.hBlue);

        } else if(face.selected == R.id.radbutskin){
            this.redTextView.setText("" + face.sRed);
            this.greenTextView.setText("" + face.sGreen);
            this.blueTextView.setText("" + face.sBlue);

        } else if(face.selected == R.id.radbuteyes){
            this.redTextView.setText("" + face.eRed);
            this.greenTextView.setText("" + face.eGreen);
            this.blueTextView.setText("" + face.eBlue);
        }
    }

    /**
     External Citation
     Date: 2/23/2024
     Problem: Was setting up HW B during Office Hours
     Resource: Dr. Nuxoll
     Solution: Discussed Do Nothings that are required in a give and take
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        face.setHairstyle(i);
        facePict.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Do Nothing
    }
    /**
     External Citation
     Date: 2/23/2024
     Problem: Needed methods required for seek bar listener
     Resource: https://developer.android.com/reference/android/widget/SeekBar.OnSeekBarChangeListener
     Solution: It was basically a copy paste of several methods
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Do Nothing
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Do Nothing
    }
}
