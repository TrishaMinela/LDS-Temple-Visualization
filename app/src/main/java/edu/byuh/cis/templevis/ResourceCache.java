package edu.byuh.cis.templevis;

import android.content.Context;
import android.util.Log;

public class ResourceCache {

    Integer testIdentifier;

    public ResourceCache(Context context) {

        testIdentifier = context.getResources().getIdentifier("antofagasta_chile_temple", "drawable", "edu.byuh.cis.templevis");

        Log.d("identifier", testIdentifier + "");
    }

}
