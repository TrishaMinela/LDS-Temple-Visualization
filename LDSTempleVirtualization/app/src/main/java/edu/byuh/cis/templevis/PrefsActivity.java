package edu.byuh.cis.templevis;

import android.content.Context;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;
import android.widget.TextView;

import edu.byuh.cis.templevis.R;

public class PrefsActivity extends PreferenceActivity {


    public static final String SPIRAL_EFFECT= "SPIRAL_EFFECT";

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);


        PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(this);

        ListPreference spiral_effect = new ListPreference(this);
        spiral_effect.setTitle(R.string.SpiralEffectTitle);
        spiral_effect.setSummary(R.string.SpiralEffectSummary);
        spiral_effect.setKey(SPIRAL_EFFECT);
        spiral_effect.setEntries(R.array.SpiralEffect);
        spiral_effect.setEntryValues(R.array.SpiralEffect_value);
        spiral_effect.setValue("static");

        screen.addPreference(spiral_effect);



        setPreferenceScreen(screen);

        //Log.d("Prefs ", "preference screen here ");

    }

    public static String getSpiralEffectPref(Context c) {
        String effect = PreferenceManager.
                getDefaultSharedPreferences(c).getString(SPIRAL_EFFECT, "static");

        /*
        if (effect.equalsIgnoreCase("static")) {
            TempleView.getNewSpiralCoordinatesStatic();
        }

         */



        return effect;
    }

}
