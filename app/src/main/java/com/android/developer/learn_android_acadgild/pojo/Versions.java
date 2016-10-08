package com.android.developer.learn_android_acadgild.pojo;

/**
 * Created by karthik90 on 10/8/2016.
 */

public class Versions {
    private int ImageId;
    private String Title;

    public Versions(int imageId, String title) {
        ImageId = imageId;
        Title = title;
    }

    public int getImageId() {
        return ImageId;
    }

    public String getTitle() {
        return Title;
    }
}
