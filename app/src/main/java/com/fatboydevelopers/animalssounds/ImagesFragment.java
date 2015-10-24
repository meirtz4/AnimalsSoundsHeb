package com.fatboydevelopers.animalssounds;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Meir on 10/20/2015.
 */
public class ImagesFragment extends android.support.v4.app.Fragment{

    private static final String[] animalsStrings = {
            "bird", "cat", "dog",  "owl", "lion", "peacock"};

    // NO SOUND: "eagle", "monkey",
    // NO IMAGE: "sheep", roster, parrot, horse,

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

    public static ImagesFragment newInstance(Activity activity) {
        mActivity = activity;
        ImagesFragment fragmentFirst = new ImagesFragment();
        return fragmentFirst;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.images_layout, container, false);

        long seed = System.nanoTime();
        Collections.shuffle(animalsList, new Random(seed));
        Iterator animalsIterator = animalsList.iterator();

        for (ImageButton button : InitImageButtons(view)){
            new Animal(GetRandomAnimal(animalsIterator), mActivity, button);
        }
        return view;
    }

    private String GetRandomAnimal(Iterator iter){
        if (!iter.hasNext())
            iter = animalsList.iterator();
        return (String) iter.next();
    }

    private List<ImageButton> InitImageButtons(View view){
        List<ImageButton> buttons = new ArrayList<>();
        buttons.add((ImageButton) view.findViewById(R.id.animal_button_top_left));
        buttons.add((ImageButton) view.findViewById(R.id.animal_button_top_middle));
        buttons.add((ImageButton) view.findViewById(R.id.animal_button_top_right));
        buttons.add((ImageButton) view.findViewById(R.id.animal_button_bottom_left));
        buttons.add((ImageButton) view.findViewById(R.id.animal_button_bottom_middle));
        buttons.add((ImageButton) view.findViewById(R.id.animal_button_bottom_right));
        return buttons;
    }
}
