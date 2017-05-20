package com.raul311.turbinetest.main.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.raul311.turbinetest.R;
import com.raul311.turbinetest.main.fragments.DetailFragment;
import com.raul311.turbinetest.main.fragments.FragmentConstants;
import com.raul311.turbinetest.service.Ad;

/**
 * @author raul311
 */

public class DetailActivity extends Activity {

    private FragmentManager fragmentManager;
    private Ad ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        fragmentManager = getFragmentManager();
        Intent intent = getIntent();
        if (intent != null) {
            this.ad = (Ad) intent.getSerializableExtra(FragmentConstants.ADVERTISEMENT_SENT);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DetailFragment detailFragment = DetailFragment.newInstance(ad);
        fragmentManager.beginTransaction().add(R.id.fragment_detail_container,
                detailFragment).commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
