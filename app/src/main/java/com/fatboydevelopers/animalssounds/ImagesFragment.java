package com.fatboydevelopers.animalssounds;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ImagesFragment extends android.support.v4.app.Fragment{

    private static final String[] animalsStrings = {
            "bird", "cat", "dog",  "owl", "lion", "peacock", "monkey", "parrot", "horse", "duck", "rooster", "goat", "sheep", "cow", "elephant"};


	// NO IMAGE:
    // NO SOUND: eagle,

    private static SharedPreferences mPreferences;
    private ArrayList<String> animalsList;
    private static Activity mActivity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animalsList = new ArrayList<>();
        for (String str : animalsStrings){
            animalsList.add(str);
        }
    }

    public static ImagesFragment newInstance(Activity activity, SharedPreferences preferences) {
        mActivity = activity;
        mPreferences = preferences;
        ImagesFragment fragmentFirst = new ImagesFragment();
        return fragmentFirst;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.images_layout, container, false);

        long seed = System.nanoTime();
        Collections.shuffle(animalsList, new Random(seed));
        Iterator animalsIterator = animalsList.iterator();

        Boolean enableAnimalsNames = mPreferences.getBoolean("ENABLE_ANIMALS_NAMES", false);

        for (Button button : InitImageButtons(view)){
            new Animal(GetRandomAnimal(animalsIterator), mActivity, button, enableAnimalsNames);
        }
        return view;
    }

    private String GetRandomAnimal(Iterator iter){
        if (!iter.hasNext())
            iter = animalsList.iterator();
        return (String) iter.next();
    }

    private List<Button> InitImageButtons(View view){
        List<Button> buttons = new ArrayList<>();
        buttons.add((Button) view.findViewById(R.id.animal_button_top_left));
        buttons.add((Button) view.findViewById(R.id.animal_button_top_middle));
        buttons.add((Button) view.findViewById(R.id.animal_button_top_right));
        buttons.add((Button) view.findViewById(R.id.animal_button_bottom_left));
        buttons.add((Button) view.findViewById(R.id.animal_button_bottom_middle));
        buttons.add((Button) view.findViewById(R.id.animal_button_bottom_right));
        return buttons;
    }
}
