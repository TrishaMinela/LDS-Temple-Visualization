package edu.byuh.cis.templevis;

import android.graphics.Bitmap;

public class Temple {
    Bitmap image;
    Float size;
    Float x;
    Float y;
    String role;
    String link;
    Boolean hasImage;

    public Temple(Bitmap imageP, Float sizeP, Float xP, Float yP, Boolean hi) {
        image = imageP;
        size = sizeP;
        x = xP;
        y = yP;
        role = "";
        link = "";
        hasImage = hi;
    }

    public Temple(Bitmap imageP, Float sizeP, Float xP, Float yP) {
        image = imageP;
        size = sizeP;
        x = xP;
        y = yP;
        role = "";
        link = "";
    }
    public void setRole(String r) {
        role = r;
    }

    public void setLink(String l) {
        link = l;
    }

    public void changeImage(Bitmap b) {
        image = b;
    }


}
