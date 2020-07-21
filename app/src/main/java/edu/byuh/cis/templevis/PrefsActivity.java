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
import android.widget.Toast;

import java.util.Locale;

import edu.byuh.cis.templevis.R;

public class PrefsActivity extends PreferenceActivity {


    public static final String SPIRAL_EFFECT= "SPIRAL_EFFECT";
    public static final String LANGUAGE_PREF= "LANGUAGE_PREF";
    public static final String SHOW_LABEL= "SHOW_LABEL";

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

        ListPreference language_pref = new ListPreference(this);
        language_pref.setTitle(R.string.language_prefs_title);
        language_pref.setSummary(R.string.language_prefs_summary);
        language_pref.setKey(LANGUAGE_PREF);
        language_pref.setEntries(R.array.language_prefs);
        language_pref.setEntryValues(R.array.language_prefs_value);

        //disable users ability to change language in the app, because there is a bug i cant fix
        //screen.addPreference(language_pref);

        CheckBoxPreference show_label = new CheckBoxPreference(this);
        show_label.setTitle(R.string.show_label_title);
        show_label.setSummaryOn(R.string.show_label_on);
        show_label.setSummaryOff(R.string.show_label_off);
        show_label.setKey(SHOW_LABEL);
        show_label.setChecked(true);
        screen.addPreference(show_label);


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

    public static String getLanguagePref(Context c) {

//        //获取当前语言环境
//        String currentLanguage = Locale.getDefault().getLanguage();
//
//        Log.d("current language is", currentLanguage);
//
//        if (currentLanguage.equalsIgnoreCase("en")) {
//            currentLanguage = "english";
//        } else if (currentLanguage.equalsIgnoreCase("zh")) {
//            currentLanguage = "chinese";
//        }

        String language = PreferenceManager.
                getDefaultSharedPreferences(c).getString(LANGUAGE_PREF, "currentLanguage");
        return language;
    }

    public static boolean getShowLabelPref(Context c) {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean(SHOW_LABEL, true);
    }
}
