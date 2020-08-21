package edu.byuh.cis.templevis;

import android.graphics.Bitmap;

public class Temple {
    Bitmap image;
    Float size;
    Float x;
    Float y;
    String role;

    public Temple(Bitmap imageP, Float sizeP, Float xP, Float yP) {
        image = imageP;
        size = sizeP;
        x = xP;
        y = yP;
        role = "";
    }

    public void setRole(String r) {
        role = r;
    }

    public void changeImage(Bitmap b) {
        image = b;
    }
}
