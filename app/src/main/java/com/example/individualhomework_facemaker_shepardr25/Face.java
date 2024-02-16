package com.example.individualhomework_facemaker_shepardr25;

import android.graphics.Canvas;
import java.util.Random;

/*
 * @author Ruth Shepard
 */
public class Face {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    // Constructor for the sole reason of calling the randomize method (at least for now :)... )
    public Face() {
        randomize();
    }

    // Initializes variables to a random valid value
    public void randomize() {
        Random random = new Random();
        // Randomly selects the correct value for each variable
        skinColor = random.nextInt(0xffffff + 1);
        eyeColor = random.nextInt(0xffffff + 1);
        hairColor = random.nextInt(0xffffff + 1);

        // Randomly selects a hairStyle (0=Curly, 1=Straight, 2=Bangs, 3=Messy)
        hairStyle = random.nextInt(4);
    }

    // Draws a Face object on a Canvas object
    public void onDraw(Canvas canvas) {
        drawHair(canvas);
        drawEyes(canvas);
        drawMouth(canvas);
    }

    // Empty Helper Methods for hair, eyes, and mouth
    private void drawHair(Canvas canvas) {
    }

    private void drawEyes(Canvas canvas) {
    }

    private void drawMouth(Canvas canvas) {

    }
}
