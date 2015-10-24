package com.fatboydevelopers.animalssounds;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Meir on 10/23/2015.
 */
public class Animal {

    private String mAnimalName;

    public Animal(String animalName, Activity activity, ImageButton button){
        animalName = animalName.toLowerCase();
        mAnimalName = animalName;


        String uri = "drawable/"+ animalName;
        int imageResource = activity.getResources().getIdentifier(uri, null, activity.getPackageName());
        button.setImageResource(imageResource);

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
