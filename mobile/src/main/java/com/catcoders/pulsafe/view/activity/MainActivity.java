package com.catcoders.pulsafe.view.activity;

import android.os.Bundle;

import com.catcoders.pulsafe.R;
import com.catcoders.pulsafe.view.fragments.HomeFragment;
import com.catcoders.pulsafe.view.fragments.MapFragment;
import com.catcoders.pulsafe.view.fragments.PeopleFragment;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;


public class MainActivity extends MaterialNavigationDrawer  {

    private static final String TAG = MainActivity.class.getName();

    @Override
    public void init(Bundle savedInstanceState) {

        this.disableLearningPattern();
        this.setDrawerHeaderImage(R.drawable.drawer_bg_top);

        // create sections
        this.addSection(newSection(getString(R.string.section_home), R.drawable.ic_home, new HomeFragment()));
        this.addSection(newSection(getString(R.string.section_people), R.drawable.ic_people, new PeopleFragment()));
        this.addSection(newSection(getString(R.string.section_map), R.drawable.ic_map, new MapFragment()));
    }

}
