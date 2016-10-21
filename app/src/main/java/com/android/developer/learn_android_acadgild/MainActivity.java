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
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.Manifest.permission.CAMERA;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQ_CODE = 1;
    Button bt_givePermission, bt_checkPermssion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_checkPermssion = (Button) findViewById(R.id.bt_givePermission);
        bt_givePermission = (Button) findViewById(R.id.bt_checkPermission);
        bt_checkPermssion.setOnClickListener(this);
        bt_givePermission.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_checkPermission:

                if (checkPermission()) {
                    Toast.makeText(this, "Permission is Granted.", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(this, "No Permission to access Camera.Click on \"Give Camera Permssion\" ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_givePermission:

                if (checkPermission()) {
                    Toast.makeText(this, "Permission Already Granted", Toast.LENGTH_SHORT).show();
                } else
                    requestPermission();

                break;

        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQ_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQ_CODE:
                if (grantResults.length > 0) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                        Toast.makeText(this, "Permission Granted.You can now check the Permission.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this, "Permission Denied.You cannot access camera.", Toast.LENGTH_SHORT).show();

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(CAMERA)) {
                            ShowPopUp("You need to grant Camera permission to make this app working", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{CAMERA}, REQ_CODE);
                                    }

                                }
                            });
                        }
                    }
                }


                break;

        }
    }

    private void ShowPopUp(String s, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(this).setTitle("Grant Permission").setPositiveButton("OK", onClickListener).setNegativeButton("Cancel", null)
                .setMessage(s)
                .setCancelable(false).create().show();
    }

    private boolean checkPermission() {
        boolean result = false;
        if (ContextCompat.checkSelfPermission(this, CAMERA) == PackageManager.PERMISSION_GRANTED)
            result = true;
        return result;
    }
}
