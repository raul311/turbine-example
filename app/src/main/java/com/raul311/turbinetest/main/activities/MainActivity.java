package com.raul311.turbinetest.main.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import com.raul311.turbinetest.R;
import com.raul311.turbinetest.main.fragments.ListFragment;

/**
 * @author raul311
 */

public class MainActivity extends Activity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragmentManager.beginTransaction().add(R.id.fragment_list_container,
                new ListFragment()).commit();
    }

}
