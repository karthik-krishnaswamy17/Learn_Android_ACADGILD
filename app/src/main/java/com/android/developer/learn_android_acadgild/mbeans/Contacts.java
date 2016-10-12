package com.android.developer.learn_android_acadgild.mbeans;

/**
 * Created by karthik90 on 10/12/2016.
 */

public class Contacts {
    private String name, phone;

    public Contacts(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }


}
