package com.android.developer.learn_android_acadgild.Utils;

import android.content.Context;

import com.android.developer.learn_android_acadgild.Database.DBHelper;

public class CommonUtilities {

    /**
     * Check if singleton object of DB is null and not open; in the case
     * reinitialize and open DB.
     *
     * @param mContext
     */
    public static DBHelper getDBObject(Context mContext) {
        DBHelper dbhelper = DBHelper.getInstance(mContext);
        return dbhelper;
    }
}
