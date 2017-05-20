package com.raul311.turbinetest.main.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.raul311.turbinetest.R;
import com.raul311.turbinetest.main.activities.DetailActivity;
import com.raul311.turbinetest.main.adapter.AdsAdapter;
import com.raul311.turbinetest.service.Ad;
import com.raul311.turbinetest.service.Ads;
import com.raul311.turbinetest.service.AdsEvent;
import com.raul311.turbinetest.service.ServiceManagerImpl;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

/**
 * @author raul311
 */

public class ListFragment extends Fragment implements AdsAdapter.AdsAdapterListener {

    private ServiceManagerImpl serviceManager;
    private Ads ads;
    private Bus bus;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ProgressBar progressBar;

    public ListFragment() {
        this.bus = new Bus();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceManager = new ServiceManagerImpl(bus);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.scrollable_main);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        bus.register(this);
        if (serviceManager != null) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            serviceManager.retrieveTurbineAds();
        }
    }

    @Override
    public  void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    @Subscribe
    public void onRetrieveAdsEvent(AdsEvent event) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        if (event.isSuccess()) {
            ads = event.getPayLoad();
            updateAdapter();
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.no_connection), Toast.LENGTH_LONG).show();
        }
    }
    private void updateAdapter() {
        adapter = new AdsAdapter(getActivity(), ads, this);
        recyclerView.setAdapter(adapter);
    }

    public void onAdSelected(Ad ad) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(FragmentConstants.ADVERTISEMENT_SENT, ad);
        startActivity(intent);
    }
}
