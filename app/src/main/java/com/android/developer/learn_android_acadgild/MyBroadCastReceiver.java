package com.android.developer.learn_android_acadgild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

/**
 * Created by karthik90 on 11/2/2016.
 */

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        Toast.makeText(context, "Value:" + level, Toast.LENGTH_SHORT).show();

    }
}
