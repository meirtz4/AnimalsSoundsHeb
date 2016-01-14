package com.fatboydevelopers.animalssounds;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsDialog extends Dialog implements DialogInterface.OnClickListener{

    public SettingsDialog(Context context, final SharedPreferences preferences) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.settings);
        Switch enableAnimalsNames = (Switch) findViewById(R.id.switchEnableAnimalsNames);
        enableAnimalsNames.setChecked(preferences.getBoolean("ENABLE_ANIMALS_NAMES", false));
        enableAnimalsNames.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferences.edit().putBoolean("ENABLE_ANIMALS_NAMES", isChecked).apply();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {}
}

