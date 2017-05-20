package com.raul311.turbinetest.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ad implements Serializable {

    @SerializedName("appId")
    @Expose
    private String appId;
    @SerializedName("averageRatingImageURL")
    @Expose
    private String averageRatingImageURL;
    @SerializedName("bidRate")
    @Expose
    private String bidRate;
    @SerializedName("callToAction")
    @Expose
    private String callToAction;
    @SerializedName("campaignDisplayOrder")
    @Expose
    private String campaignDisplayOrder;
    @SerializedName("campaignId")
    @Expose
    private String campaignId;
    @SerializedName("campaignTypeId")
    @Expose
    private String campaignTypeId;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("clickProxyURL")
    @Expose
    private String clickProxyURL;
    @SerializedName("creativeId")
    @Expose
    private String creativeId;
    @SerializedName("homeScreen")
    @Expose
    private String homeScreen;
    @SerializedName("impressionTrackingURL")
    @Expose
    private String impressionTrackingURL;
    @SerializedName("isRandomPick")
    @Expose
    private String isRandomPick;
    @SerializedName("minOSVersion")
    @Expose
    private String minOSVersion;
    @SerializedName("numberOfRatings")
    @Expose
    private String numberOfRatings;
    @SerializedName("productDescription")
    @Expose
    private String productDescription;
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productThumbnail")
    @Expose
    private String productThumbnail;
    @SerializedName("rating")
    @Expose
    private String rating;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAverageRatingImageURL() {
        return averageRatingImageURL;
    }

    public void setAverageRatingImageURL(String averageRatingImageURL) {
        this.averageRatingImageURL = averageRatingImageURL;
    }

    public String getBidRate() {
        return bidRate;
    }

    public void setBidRate(String bidRate) {
        this.bidRate = bidRate;
    }

    public String getCallToAction() {
        return callToAction;
    }

    public void setCallToAction(String callToAction) {
        this.callToAction = callToAction;
    }

    public String getCampaignDisplayOrder() {
        return campaignDisplayOrder;
    }

    public void setCampaignDisplayOrder(String campaignDisplayOrder) {
        this.campaignDisplayOrder = campaignDisplayOrder;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignTypeId() {
        return campaignTypeId;
    }

    public void setCampaignTypeId(String campaignTypeId) {
        this.campaignTypeId = campaignTypeId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getClickProxyURL() {
        return clickProxyURL;
    }

    public void setClickProxyURL(String clickProxyURL) {
        this.clickProxyURL = clickProxyURL;
    }

    public String getCreativeId() {
        return creativeId;
    }

    public void setCreativeId(String creativeId) {
        this.creativeId = creativeId;
    }

    public String getHomeScreen() {
        return homeScreen;
    }

    public void setHomeScreen(String homeScreen) {
        this.homeScreen = homeScreen;
    }

    public String getImpressionTrackingURL() {
        return impressionTrackingURL;
    }

    public void setImpressionTrackingURL(String impressionTrackingURL) {
        this.impressionTrackingURL = impressionTrackingURL;
    }

    public String getIsRandomPick() {
        return isRandomPick;
    }

    public void setIsRandomPick(String isRandomPick) {
        this.isRandomPick = isRandomPick;
    }

    public String getMinOSVersion() {
        return minOSVersion;
    }

    public void setMinOSVersion(String minOSVersion) {
        this.minOSVersion = minOSVersion;
    }

    public String getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(String numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
