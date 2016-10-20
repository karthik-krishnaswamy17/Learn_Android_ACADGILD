package com.android.developer.learn_android_acadgild.mBeans;

/**
 * Created by karthik90 on 10/20/2016.
 */

public class Details {

    private String name, dob, phone;

    public Details(String name, String phone, String dob) {
        this.name = name;
        this.phone = phone;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }
}

