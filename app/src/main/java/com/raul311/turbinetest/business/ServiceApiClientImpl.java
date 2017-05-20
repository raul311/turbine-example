package com.raul311.turbinetest.business;

import com.raul311.turbinetest.service.Ads;
import com.raul311.turbinetest.service.Payload;
import com.raul311.turbinetest.service.ServiceManagerConstants;
import com.squareup.otto.Bus;

import java.io.IOException;

/**
 * @author raul311
 */

public class ServiceApiClientImpl implements ServiceApiClient {

    private Ads ads;
    private Bus bus;

    public interface ServiceApiClientCallback {
        void onTaskDone(Payload payload);
    }

    public ServiceApiClientImpl(Bus bus) {
        this.bus = bus;
        this.bus.register(this);
    }

    public void getAllTurbineAds() throws IOException {
        new HttpClient(new ServiceApiClientCallback() {
            @Override
            public void onTaskDone(Payload payload) {
                setResult(payload);
            }
        }).execute(ServiceManagerConstants.ADD_URL);

    }

    private void setResult(Payload payload) {
        bus.post(payload.getAds());
    }
}
