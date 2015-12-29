package com.fatboydevelopers.animalssounds;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

/**
 * Created by Meir on 12/16/2015.
 */
public class StoreButton {
    // Premium
    public void Action(View view){
        String myUrl ="https://play.google.com/store/apps/details?id=com.fatboydevelopers.animalssounds.premium";
        view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl)));
    }
}
