package com.example.individualhomework_facemaker_shepardr25;

import static android.graphics.Color.rgb;
import kotlin.random.Random;

/*
 * @author Ruth Shepard
 */

public class Face {
    //Main Colors
    public int red, green, blue;

    //Skin Tones
    public int skinTone, sRed, sGreen, sBlue;

    //Eye Colors
    public int eyeColor, eRed, eGreen, eBlue;

    //Hair Colors
    public int hairColor, hRed, hGreen, hBlue, hairstyle;
    
    int selected = R.id.radbuthair;

    public Face() {
        this.randomize();
    }

    void randomize() {
        //Skin Tone RGB Colors
        this.sRed = Random.Default.nextInt(255);
        this.sGreen = Random.Default.nextInt(255);
        this.sBlue = Random.Default.nextInt(255);

        //Eyes RGB Colors
        this.eRed = Random.Default.nextInt(255);
        this.eGreen = Random.Default.nextInt(255);
        this.eBlue = Random.Default.nextInt(255);

        //Hair RGB Colors
        this.hRed = Random.Default.nextInt(255);
        this.hGreen = Random.Default.nextInt(255);
        this.hBlue = Random.Default.nextInt(255);
        this.hairstyle = Random.Default.nextInt(4);

        //Compile the rgb colors
        skinTone = rgb(sRed, sGreen, sBlue);
        eyeColor = rgb(eRed, eGreen, eBlue);
        hairColor = rgb(hRed, hGreen, hBlue);
    }

    public void setHairColor(int x) {
        this.hairColor = x;
    }

    public void setEyeColor(int x) {
        this.eyeColor = x;
    }

    public void setSkinTone(int x) {
        this.skinTone = x;
    }

    public void setHairstyle(int x) {
        this.hairstyle = x;
    }
}
