package com.android.developer.learn_android_acadgild.pojo;

/**
 * Created by karthik90 on 10/15/2016.
 */

public class Websites {

    private int WebsiteDrawableId;
    private String WebsiteTitle, WebsiteDescription;

    public Websites(int websiteDrawableId, String websiteTitle, String websiteDescription) {
        WebsiteDrawableId = websiteDrawableId;
        WebsiteTitle = websiteTitle;
        WebsiteDescription = websiteDescription;
    }

    public int getWebsiteDrawableId() {
        return WebsiteDrawableId;
    }

    public String getWebsiteTitle() {
        return WebsiteTitle;
    }

    public String getWebsiteDescription() {
        return WebsiteDescription;
    }
}
