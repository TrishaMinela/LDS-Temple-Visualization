package com.ldstemplevirtualization;


import android.graphics.Bitmap;
import android.graphics.RectF;

public class Temple {

    protected Bitmap image;
    protected RectF bounds;
    protected float size;

    public Temple(Bitmap b) {

        image = b;
        bounds.set(0, 0, image.getWidth(), image.getHeight());

    }
}
