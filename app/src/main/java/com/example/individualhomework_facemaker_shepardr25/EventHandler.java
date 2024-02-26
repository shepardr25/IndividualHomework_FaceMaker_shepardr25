package com.example.individualhomework_facemaker_shepardr25;

import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EventHandler implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener {

    private TextView redTextView, greenTextView, blueTextView;
    private Face face;

    public EventHandler(TextView redTextView, TextView greenTextView, TextView blueTextView) {
        this.redTextView = redTextView;
        this.greenTextView = greenTextView;
        this.blueTextView = blueTextView;
        this.face = face;
    }
    @Override
    public void onClick(View view) {
        // Button Click handler
        if (view.getId() == R.id.ranbutton) {
            face.randomize();
            face.invalidate();
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (seekBar.getId() == R.id.rseekbar) {
            redTextView.setText(String.valueOf(i));
        } else if (seekBar.getId() == R.id.gseekbar) {
            greenTextView.setText(String.valueOf(i));
        } else if (seekBar.getId() == R.id.bseekbar) {
            blueTextView.setText(String.valueOf(i));
        }
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Unnecessary
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Unnecessary
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Spinner item selection handler
        String selectedHairstyle = (String) parent.getItemAtPosition(position);
        face.setHairstyle(selectedHairstyle); // Assuming you have a setHairstyle method in Face class
        face.invalidate(); // To redraw the Face view
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }
}
