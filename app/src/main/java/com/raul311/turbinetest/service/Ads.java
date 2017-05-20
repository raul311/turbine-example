package com.raul311.turbinetest.service;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ads {

    @SerializedName("-xmlns")
    @Expose
    private String xmlns;
    @SerializedName("ad")
    @Expose
    private List<Ad> ad = null;
    @SerializedName("responseTime")
    @Expose
    private String responseTime;
    @SerializedName("serverId")
    @Expose
    private String serverId;
    @SerializedName("totalCampaignsRequested")
    @Expose
    private String totalCampaignsRequested;
    @SerializedName("version")
    @Expose
    private String version;

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public List<Ad> getAd() {
        return ad;
    }

    public void setAd(List<Ad> ad) {
        this.ad = ad;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getTotalCampaignsRequested() {
        return totalCampaignsRequested;
    }

    public void setTotalCampaignsRequested(String totalCampaignsRequested) {
        this.totalCampaignsRequested = totalCampaignsRequested;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
