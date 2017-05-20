package com.raul311.turbinetest.business;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.raul311.turbinetest.service.Ad;
import com.raul311.turbinetest.service.Ads;
import com.raul311.turbinetest.service.Payload;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author raul311
 */

public class HttpClient extends AsyncTask<String, Void, Void> {

    private ServiceApiClientImpl.ServiceApiClientCallback serviceApiClientCallback;
    private OkHttpClient client;
    private Gson gson;
    private Payload payLoad;
    JsonParser parser;

    public HttpClient(ServiceApiClientImpl.ServiceApiClientCallback serviceApiClientCallback) {
        this.serviceApiClientCallback = serviceApiClientCallback;
        this.gson = new Gson();
        client = new OkHttpClient();
        parser = new JsonParser();
    }

    @Override
    public Void doInBackground(String... params) {
        try {
            Request request = new Request.Builder().url(params[0]).build();
            Response response = client.newCall(request).execute();
            XmlToJson xmlToJson = new XmlToJson.Builder(response.body().string()).build();
            payLoad = new Payload();
            payLoad.setAds(transformAdds(xmlToJson.toFormattedString()));
        } catch (IOException e) {
            Log.i("", e.getMessage());
        } catch (Exception e) {
            Log.i("", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        Log.i("", "onPostExecute");
        serviceApiClientCallback.onTaskDone(payLoad);
    }

    @Override
    protected void onPreExecute() {
        Log.i("", "onPreExecute");
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        Log.i("", "onProgressUpdate");
    }

    private Ads transformAdds(String jsonString) {
        JsonElement rootElement = parser.parse(jsonString).getAsJsonObject().get("ads");
        JsonElement adElement = parser.parse(rootElement.toString()).getAsJsonObject().get("ad");
        Ads result = new Ads();
        List<Ad> ads = new ArrayList<>();

        if (adElement.isJsonObject()) {
            ads.add(gson.fromJson(adElement, Ad.class));
        } else if (adElement.isJsonArray()) {
            Type projectListType = new TypeToken<List<Ad>>() {}.getType();
            ads = gson.fromJson(adElement, projectListType);
        }
        result.setAd(ads);
        return result;
    }

}
