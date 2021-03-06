
package com.example.myfirstapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.myfirstapp.Display.screenRatioX;
import static com.example.myfirstapp.Display.screenRatioY;

public class Asteroid {

    public int speed = 8;
    public boolean wasShot = true;
    public boolean bossStageBegins = false;
    int x = 0, y, width, height, asteroidCounter = 1;
    Bitmap ship, destroyed, boss;
    public boolean crashed = false;

    Asteroid (Resources res) {
        ship = BitmapFactory.decodeResource(res, R.drawable.one);
        destroyed = BitmapFactory.decodeResource(res, R.drawable.explosion);
        boss = BitmapFactory.decodeResource(res, R.drawable.boss1a);

        width = ship.getWidth() / 2;
        height = ship.getHeight() / 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        ship = Bitmap.createScaledBitmap(ship, width, height, false);

        y = -height;
    }
    Bitmap getAsteroid() {
        asteroidCounter = 1;
        if (crashed) {
            if (!bossStageBegins) {
                return destroyed;
            } else {
                x = x + 100;
                return boss;
            }
        }
        if (bossStageBegins) {
            return boss;
        }
        return ship;
    }

    Rect getCollisionShape () {
        //return new Rect(x, y, x + width, y + height);
        return new Rect(x, y - 2000, x + width, y + 3000);
    }
}