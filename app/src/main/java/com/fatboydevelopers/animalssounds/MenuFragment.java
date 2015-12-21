package com.fatboydevelopers.animalssounds;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Meir on 10/20/2015.
 */
public class MenuFragment extends android.support.v4.app.Fragment{

    private static Activity mActivity;

    // newInstance constructor for creating fragment with arguments
    public static MenuFragment newInstance(Activity activity) {
        mActivity = activity;
        MenuFragment fragmentFirst = new MenuFragment();
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
        View view = inflater.inflate(R.layout.menu_layout, container, false);
        SetOnClickListeners(view);
        return view;
    }

    public void SetOnClickListeners(View view) {
        Button aboutButton = (Button) view.findViewById(R.id.menu_button_about);
        Button settingsButton = (Button) view.findViewById(R.id.menu_button_settings);
        Button storeButton = (Button) view.findViewById(R.id.menu_button_store);

        aboutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new AlertDialog.Builder(mActivity)
                        .setTitle(R.string.title_about_us)
                        .setMessage(R.string.message_about_us)
                        .setIcon(R.drawable.ic_launcher)
                        .show();
            }
        });

        storeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new StoreButton().Action();
            }
        });
    }
}
