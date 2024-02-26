package com.example.individualhomework_facemaker_shepardr25;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;

/*
 * @author Ruth Shepard
 */
public class DrawFace extends SurfaceView {
    Face billyBob = new Face();

    public Paint skin = new Paint();
    public Paint eyes = new Paint();
    public Paint hair = new Paint();
    public Paint mouth = new Paint();

    public DrawFace(Context context, AttributeSet attributeSet) {
        /**
         External Citation
         Date: 2/23/2024
         Problem: Was setting up HW B during Office Hours
         Resource: Dr. Nuxoll
         Solution: Discussed the purpuse of super, and of set will not draw
         */
        super(context, attributeSet);
        setWillNotDraw(false);
    }
        /* Original Colors for skin tone, eyes, hair, and mouth
            skin.setColor(0xFFe6d0c3);  // Color is a Nude Pink
            skin.setStyle(Paint.Style.FILL);

            eyes.setColor(0xFF7bacc7);  // Color is an Aqua Blue
            eyes.setStyle(Paint.Style.FILL);

            hair.setColor(0xFF4f3f32);  // Color is a Rust Brown
            hair.setStyle(Paint.Style.FILL);

            mouth.setColor(Color.BLACK);  // Color is Black
            mouth.setStyle(Paint.Style.FILL);
        */

    public void onDraw(Canvas canvas) {
        //Color for Skin Tone
        this.skin.setColor(billyBob.skinTone);
        skin.setStyle(Paint.Style.FILL);

        //Color for Eyes
        this.eyes.setColor(billyBob.eyeColor);
        eyes.setStyle(Paint.Style.FILL);

        //Color for Hair
        this.hair.setColor(billyBob.hairColor);
        hair.setStyle(Paint.Style.FILL);

        //Background Color
        setBackgroundColor(0xFF859fa8);

        //Draw Portions of Face
        drawHead(canvas);
        drawHair(canvas);
        drawEyes(canvas);
        drawMouth(canvas);
        drawNose(canvas);
    }
    public Face getFace() {
        return billyBob;
    }

    /**
     External Citation
     Date: 2/25/2024
     Problem: Was struggling with understanding how to position shapes on canvas
     Resource: Divya
     Solution: Reviewed her HW and discussed the purpose of her integer variables
     */
    public void drawHead(Canvas canvas) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int faceWidth = 500;
        int faceHeight = 680;

        int left = centerX - faceWidth / 2;
        int top = centerY - faceHeight / 2;
        int right = centerX + faceWidth / 2;
        int bottom = centerY + faceHeight / 2;

        RectF faceRect = new RectF(left, top, right, bottom);
        canvas.drawOval(faceRect, skin);
    }
    public void drawHair(Canvas canvas) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int faceWidth = 500;
        int faceHeight = 680;

        if(billyBob.hairstyle == 1) {
            //Lines
            canvas.drawLine(350, 250, 350, 650, hair);
            canvas.drawLine(300, 250, 350, 650, hair);
            canvas.drawLine(750, 250, 750, 650, hair);
            canvas.drawLine(700, 250, 750, 650, hair);
        } else if (billyBob.hairstyle == 2) {
            //Weird Mowhawk
            int hairWidth = 200; // Adjust hair width
            int hairHeight = 300; // Adjust hair height

            int hairTop = centerY - faceHeight / 2 - hairHeight; // Hair starts at top of head

            canvas.drawRect(centerX - hairWidth / 2, hairTop, centerX + hairWidth / 2,
                    hairTop + hairHeight, hair);
        } else if (billyBob.hairstyle == 3) {
            //Ugly Bangs
            int hairWidth = 300;
            int hairHeight = 200;
            int hairStartAngle = 180;
            int hairSweepAngle = 180;
            int hairTop = centerY - 550 / 2 - hairHeight / 2;
            RectF hairRect = new RectF(centerX - hairWidth / 2, hairTop,
                    centerX + hairWidth / 2, hairTop + hairHeight);
            canvas.drawArc(hairRect, hairStartAngle, hairSweepAngle, false, hair);
        } else if (billyBob.hairstyle == 4) {
            //None because the hairStyle is bald
        }
    }

    public void drawEyes(Canvas canvas) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int eyeRad = 30;
        int eyeDistance = 120;
        canvas.drawCircle(centerX - eyeDistance, centerY - 50, eyeRad, eyes);
        canvas.drawCircle(centerX + eyeDistance, centerY - 50, eyeRad, eyes);
    }

    public void drawMouth(Canvas canvas) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int mouthWidth = 200;
        int mouthHeight = 100;
        RectF mouthRect = new RectF(centerX - mouthWidth / 2, centerY + 100,
                centerX + mouthWidth / 2, centerY + 100 + mouthHeight);
        canvas.drawArc(mouthRect, 0f, 180f, false, mouth);
    }

    public void drawNose(Canvas canvas) {
        int noseWidth = 60;
        int noseHeight = 70;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        Path nosePath = new Path();
        nosePath.moveTo(centerX - noseWidth / 2, centerY + 20);
        nosePath.lineTo(centerX, centerY - noseHeight);
        nosePath.lineTo(centerX + noseWidth / 2, centerY + 20);
        nosePath.close();
        Paint nosePaint = new Paint();
        nosePaint.setColor(0xFFd9b895);
        nosePaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(nosePath, nosePaint);
    }
}
