package com.fatboydevelopers.animalssounds;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meir on 10/20/2015.
 */
public class ImagesFragment extends android.support.v4.app.Fragment{

    private static Activity mActivity;
    private List<Animal> animals;
    private static final String[] animalsStrings = {"dog"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animals = new ArrayList<>();
    }

    public static ImagesFragment newInstance(Activity activity) {
        mActivity = activity;
        ImagesFragment fragmentFirst = new ImagesFragment();
        return fragmentFirst;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.images_layout, container, false);
        for (ImageButton button : InitImageButtons(view)){
            animals.add(new Animal(GetRandomAnimal(), mActivity, button));
        }
        return view;
    }

    private String GetRandomAnimal(){
        // TODO
        return "dog";
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
