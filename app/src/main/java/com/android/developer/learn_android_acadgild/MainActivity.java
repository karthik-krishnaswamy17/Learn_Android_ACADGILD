package com.android.developer.learn_android_acadgild;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PERM_CODE = 117;
    Button bt_addData, bt_deleteFile;
    private RelativeLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!checkExtPermission())
            requestPermission();
        setContentView(R.layout.activity_main);
        bt_addData = (Button) findViewById(R.id.bt_data);
        bt_deleteFile = (Button) findViewById(R.id.bt_delete);
        bt_addData.setOnClickListener(this);
        bt_deleteFile.setOnClickListener(this);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERM_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        container = (RelativeLayout) findViewById(R.id.container);
        switch (requestCode) {

            case PERM_CODE:

                if (grantResults.length > 0) {
                    boolean writeAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean readAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (writeAccepted && readAccepted)
                        Snackbar.make(container, "Permission Granted.You can now add data/delete", Snackbar.LENGTH_LONG).show();
                    else
                        Snackbar.make(container, "Permission Denied.You need access to storage to use this app.", Snackbar.LENGTH_LONG).show();

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) {
                            showMessageOKCancel("You need to grant Storage access to use this app ",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE},
                                                        PERM_CODE);
                                            }
                                        }
                                    });
                            return;
                        }
                    }

                }
                break;
        }

    }

    private void showMessageOKCancel(String s, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(s)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }


    private boolean checkExtPermission() {
        int writeRes = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int readRes = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return ((writeRes == PackageManager.PERMISSION_GRANTED) && (readRes == PackageManager.PERMISSION_GRANTED));
    }


    @Override
    public void onClick(View v) {
        new BackgroundActivity(this).execute(v.getId());
    }


}
