package com.android.developer.learn_android_acadgild;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static android.Manifest.permission.READ_SMS;

public class MainActivity extends AppCompatActivity {
    private static final int REQ_CODE = 17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!checkSMSPermission())
            requestSMSPermission();
    }

    private void requestSMSPermission() {
        ActivityCompat.requestPermissions(this, new String[]{READ_SMS}, REQ_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0) {
            if (!(grantResults[0] == PackageManager.PERMISSION_GRANTED))
                Toast.makeText(this, "Permission Denied.You cannot Use this app to receive broadcast messages.", Toast.LENGTH_SHORT).show();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (shouldShowRequestPermissionRationale(READ_SMS)) {
                ShowPopUp("You need to grant SMS permission to receive broadcast messages", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            requestPermissions(new String[]{READ_SMS}, REQ_CODE);
                        }
                    }
                });
            }
        }
    }


    private boolean checkSMSPermission() {
        boolean result;
        result = ContextCompat.checkSelfPermission(this, READ_SMS) == PackageManager.PERMISSION_GRANTED;
        return result;
    }


    private void ShowPopUp(String s, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(this).setTitle("Grant Permission").setPositiveButton("OK", onClickListener).setNegativeButton("Cancel", null)
                .setMessage(s)
                .setCancelable(false).create().show();
    }

}
