package com.fatboydevelopers.animalssounds;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Meir on 10/23/2015.
 */
public class Animal {

    private String mAnimalName;

    public Animal(String animalName, Activity activity, Button button, Boolean enableAnimalsNames){
        animalName = animalName.toLowerCase();
        mAnimalName = animalName;


        String uri = "drawable/"+ animalName;
        Drawable imageResource = activity.getResources().getDrawable(
                activity.getResources().getIdentifier(uri, null, activity.getPackageName()), null);
        button.setBackground(imageResource);

        if (enableAnimalsNames) {
            String text = activity.getResources().getString(
                    activity.getResources().getIdentifier(animalName, "string", activity.getPackageName()));
            button.setText(text);
        } else {
            button.setText("");
        }

        uri = "raw/"+ animalName;
        int soundResource = activity.getResources().getIdentifier(uri, null, activity.getPackageName());
        final MediaPlayer mp = MediaPlayer.create(activity, soundResource);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mp.start();
            }
        });
    }

    public String getAnimalName()
    {
        return this.mAnimalName;
    }
}
