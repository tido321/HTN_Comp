package com.example.htngame;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.htngame.GameView.screenRatioX;
import static com.example.htngame.GameView.screenRatioY;


public class Flight {
    int x, y, width, height, wingCounter = 0;
    Bitmap flight1, flight2, dead;

    Flight (int screenY, Resources res) {

        flight1 = BitmapFactory.decodeResource(res, R.drawable.fly1);
        flight2 = BitmapFactory.decodeResource(res, R.drawable.fly2);

        width = flight1.getWidth();
        height = flight1.getHeight();

        width /= 4;
        height /= 4;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        flight1 = Bitmap.createScaledBitmap(flight1, width, height, false);
        flight2 = Bitmap.createScaledBitmap(flight2, width, height, false);

        dead = BitmapFactory.decodeResource(res, R.drawable.dead);
        dead = Bitmap.createScaledBitmap(dead, width, height, false);

        y = screenY /2;
        x = (int) (64 * screenRatioX);

    }

    Bitmap getFlight () {

        if (wingCounter == 0) {
            wingCounter++;
            return flight1;
        }

        wingCounter--;

        return flight2;
    }

    Rect getCollisionShape () {
        return new Rect(x, y, x + width, y + height);
    }

    Bitmap getDead() {
        return dead;
    }
}
