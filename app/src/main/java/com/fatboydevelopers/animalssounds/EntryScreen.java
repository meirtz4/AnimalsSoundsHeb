package com.fatboydevelopers.animalssounds;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.tobishiba.circularviewpager.library.BaseCircularViewPagerAdapter;
import com.tobishiba.circularviewpager.library.CircularViewPagerHandler;

import java.util.ArrayList;
import java.util.List;

public class EntryScreen extends AppCompatActivity {


    private long BackButtonFirstClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SetViewPager();
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - BackButtonFirstClick < 1000){
            finish();
            System.exit(0);
        }
        BackButtonFirstClick = System.currentTimeMillis();
    }

    public void SetViewPager(){
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        List<String> strings = new ArrayList<>();
        strings.add("Images");
        strings.add("Images");
        strings.add("Images");
        strings.add("Menu");
        strings.add("Images");
        strings.add("Images");
        strings.add("Images");
        vpPager.setAdapter(new MemeCircularViewPagerAdapter(this, getSupportFragmentManager(), strings));
        vpPager.setOnPageChangeListener(new CircularViewPagerHandler(vpPager));
    }

    public class MemeCircularViewPagerAdapter extends BaseCircularViewPagerAdapter<String> {
        private final Context mContext;
        private final SharedPreferences mPreferences;

        public MemeCircularViewPagerAdapter(final Context context, final android.support.v4.app.FragmentManager fragmentManager, final List<String> strings) {
            super(fragmentManager, strings);
            mContext = context;
            mPreferences = mContext.getSharedPreferences("com.fatboydevelopers.animalssounds", Context.MODE_PRIVATE);
        }

        @Override
        protected android.support.v4.app.Fragment getFragmentForItem(final String str) {
            if (str.equals("Menu"))
                return MenuFragment.newInstance(EntryScreen.this, mPreferences);

            return ImagesFragment.newInstance(EntryScreen.this, mPreferences);
        }
    }
}
