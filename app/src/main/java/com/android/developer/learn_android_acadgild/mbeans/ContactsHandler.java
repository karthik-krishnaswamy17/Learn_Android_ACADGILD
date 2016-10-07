package com.android.developer.learn_android_acadgild.mbeans;

/**
 * Created by karthik90 on 10/7/2016.
 */

public class ContactsHandler {
    private String name, phone;

    public ContactsHandler(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }


    public String getPhone() {
        return phone;
    }


}
