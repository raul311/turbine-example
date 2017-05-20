package com.raul311.turbinetest.service;

/**
 *  @author raul311
 */

public interface ServiceManager {

    void retrieveTurbineAds();

    AdsEvent getTurbineAds();

    void onTurbineAds(Ads ads);

}
