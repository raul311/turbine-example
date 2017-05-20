package com.raul311.turbinetest.service;

import android.util.Log;
import com.raul311.turbinetest.business.ServiceApiClientImpl;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import java.io.IOException;

/**
 * @author raul311
 */

public class ServiceManagerImpl implements ServiceManager {

    private final ServiceApiClientImpl serviceApiClient;
    private Ads ads;
    private Bus bus;

    public ServiceManagerImpl(Bus bus) {
        this.bus = bus;
        this.bus.register(this);
        this.serviceApiClient = new ServiceApiClientImpl(bus);
    }

    public void retrieveTurbineAds() {
        try {
            serviceApiClient.getAllTurbineAds();
        } catch (IOException e) {
            Log.i(ServiceManagerConstants.TAG, e.getMessage());
        } catch (Exception e) {
            Log.i(ServiceManagerConstants.TAG, e.getMessage());
        }
    }

    @Subscribe
    public void onTurbineAds(Ads ads) {
        this.ads = ads;
        bus.post(new AdsEvent(ads));
    }

    public AdsEvent getTurbineAds() {
        return new AdsEvent(ads);
    }
}
