package com.fatboydevelopers.animalssounds;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Meir on 10/20/2015.
 */
public class ImagesFragment extends android.support.v4.app.Fragment{

    // newInstance constructor for creating fragment with arguments
    public static ImagesFragment newInstance(int page, String title) {
        ImagesFragment fragmentFirst = new ImagesFragment();
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.images_layout, container, false);
        return view;
    }
}
