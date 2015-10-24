package com.fatboydevelopers.animalssounds;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageButton;

import java.io.File;

/**
 * Created by Meir on 10/23/2015.
 */
public class Animal {

    private String mAnimalName;

    public Animal(String animalName, Activity activity, ImageButton button){
        animalName = animalName.toLowerCase();
        mAnimalName = animalName;
        button.setImageResource(R.drawable.dog);
        final MediaPlayer mp = MediaPlayer.create(activity, R.raw.dog);
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
