package edu.byuh.cis.templevis;

import android.graphics.Bitmap;

public class Temple {
    Bitmap image;
    Float size;
    Float x;
    Float y;
    public Temple(Bitmap imageP, Float sizeP, Float xP, Float yP) {
        image = imageP;
        size = sizeP;
        x = xP;
        y = yP;
    }
}
