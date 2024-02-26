package com.example.individualhomework_facemaker_shepardr25;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.graphics.Path;

import java.util.Random;

/*
 * @author Ruth Shepard
 */
public class Face extends SurfaceView {
    private int skinColor = 0;
    private int eyeColor = 0;
    private int hairColor = 0;
    private int hairStyle = 0;

    private Paint circlePaint = new Paint();
    private Paint skin = new Paint();
    private Paint eyes = new Paint();
    private Paint hair = new Paint();
    private Paint mouth = new Paint();

    public Face(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        circlePaint.setColor(Color.BLUE);
        randomize();

        setWillNotDraw(false);

        skin.setColor(0xFFe6d0c3);  // Color is a Nude Pink
        skin.setStyle(Paint.Style.FILL);

        eyes.setColor(0xFF7bacc7);  // Color is an Aqua Blue
        eyes.setStyle(Paint.Style.FILL);

        hair.setColor(0xFF4f3f32);  // Color is a Rust Brown
        hair.setStyle(Paint.Style.FILL);

        mouth.setColor(Color.BLACK);  // Color is Black
        mouth.setStyle(Paint.Style.FILL);

        setBackgroundColor(0xFF859fa8);
    }

    public void randomize() {
        Random random = new Random();
        skinColor = random.nextInt(0xffffff + 1);
        eyeColor = random.nextInt(0xffffff + 1);
        hairColor = random.nextInt(0xffffff + 1);
        hairStyle = random.nextInt(4);
    }

    public void setHairstyle(String hairstyle) {
        switch (hairstyle) {
            case "Lines":
                hairStyle = 1;
                break;
            case "Mowhawk":
                hairStyle = 2;
                break;
            case "Bangs":
                hairStyle = 3;
                break;
            case "Bald":
                hairStyle = 4;
                break;
        }
        invalidate(); // Request redraw of the face
    }

    public void onDraw(Canvas canvas) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int faceWidth = 500;
        int faceHeight = 680;

        int left = centerX - faceWidth / 2;
        int top = centerY - faceHeight / 2;
        int right = centerX + faceWidth / 2;
        int bottom = centerY + faceHeight / 2;

        drawHair(canvas);
        drawEyes(canvas);
        drawMouth(canvas);

        RectF faceRect = new RectF(left, top, right, bottom);
        canvas.drawOval(faceRect, skin);

        int eyeRad = 30;
        int eyeDistance = 120;
        canvas.drawCircle(centerX - eyeDistance, centerY - 50, eyeRad, eyes);
        canvas.drawCircle(centerX + eyeDistance, centerY - 50, eyeRad, eyes);

        int noseWidth = 60;
        int noseHeight = 70;
        Path nosePath = new Path();
        nosePath.moveTo(centerX - noseWidth / 2, centerY + 20);
        nosePath.lineTo(centerX, centerY - noseHeight);
        nosePath.lineTo(centerX + noseWidth / 2, centerY + 20);
        nosePath.close();
        Paint nosePaint = new Paint();
        nosePaint.setColor(0xFFd9b895);
        nosePaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(nosePath, nosePaint);

        int mouthWidth = 200;
        int mouthHeight = 100;
        RectF mouthRect = new RectF(centerX - mouthWidth / 2, centerY + 100, centerX + mouthWidth / 2, centerY + 100 + mouthHeight);
        canvas.drawArc(mouthRect, 0f, 180f, false, mouth);

        if(hairStyle == 1) {
            //Lines
            canvas.drawLine(350, 250, 350, 650, hair);
            canvas.drawLine(300, 250, 350, 650, hair);
            canvas.drawLine(750, 250, 750, 650, hair);
            canvas.drawLine(700, 250, 750, 650, hair);
        } else if (hairStyle == 2) {
            // Mowhawk
            int hairWidth = 200; // Adjust hair width
            int hairHeight = 300; // Adjust hair height

            int hairTop = centerY - faceHeight / 2 - hairHeight; // Hair starts at top of head

            canvas.drawRect(centerX - hairWidth / 2, hairTop, centerX + hairWidth / 2, hairTop + hairHeight, hair);
        } else if (hairStyle == 3) {
            // Ugly Bangs
            int hairWidth = 300;
            int hairHeight = 200;
            int hairStartAngle = 180;
            int hairSweepAngle = 180;
            int hairTop = centerY - 550 / 2 - hairHeight / 2;
            RectF hairRect = new RectF(centerX - hairWidth / 2, hairTop, centerX + hairWidth / 2, hairTop + hairHeight);
            canvas.drawArc(hairRect, hairStartAngle, hairSweepAngle, false, hair);
        } else if (hairStyle == 4) {
            // Bald
            //None because the hairStyle is bald
        }
    }

    private void drawHair(Canvas canvas) {
        // Draw common hair elements if any
    }

    private void drawEyes(Canvas canvas) {
        // Draw common eye elements if any
    }

    private void drawMouth(Canvas canvas) {
        // Draw common mouth elements if any
    }
}
