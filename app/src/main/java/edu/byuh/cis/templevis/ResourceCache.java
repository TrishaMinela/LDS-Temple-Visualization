package edu.byuh.cis.templevis;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ResourceCache {

    Integer testIdentifier;
    private ArrayList<String> templeNames = new ArrayList<>();
    public  ArrayList<Integer> smallImageIdentifiers = new ArrayList<>();

    public ResourceCache(Context context) {

        testIdentifier = context.getResources().getIdentifier("antofagasta_chile_temple", "drawable", "edu.byuh.cis.templevis");
        Log.d("identifier 11111", testIdentifier + "");
        Log.d("identifier 22222", R.drawable.antofagasta_chile_temple + "");

        readInfoFile(context);

        Log.d("temple names", templeNames.toString());

        for (String s:templeNames) {
            Integer identifier = context.getResources().getIdentifier(s.substring(0,s.length()-1), "drawable", "edu.byuh.cis.templevis");
            smallImageIdentifiers.add(identifier);
            Log.d("identifier", identifier + " is " + s);

        }


    }

    public void readInfoFile(Context context) {
        try {
            InputStream templeNamesFile = context.getResources().openRawResource(R.raw.temple_names);
            if (templeNamesFile != null)
            {
                InputStreamReader ir = new InputStreamReader(templeNamesFile);
                BufferedReader br = new BufferedReader(ir);
                String line;
                //read each line
                while (( line = br.readLine()) != null) {
                    templeNames.add(line+"\n");
                }
                templeNamesFile.close();
            }
        }
        catch (FileNotFoundException e)
        {
            Log.d("File", "The File doesn't not exist.");
        }
        catch (IOException e)
        {
            Log.d("File", e.getMessage());
        }

    }

}
