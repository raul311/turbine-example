package com.raul311.turbinetest.service;

/**
 * @author raul311
 */

public class AdsEvent {

    private final Ads ads;

    public AdsEvent(Ads ads) {
        this.ads = ads;
    }

    public Ads getPayLoad() {
        return ads;
    }

    public boolean isSuccess() {
        return ads != null;
    }
}
