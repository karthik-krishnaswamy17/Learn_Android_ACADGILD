package com.android.developer.learn_android_acadgild;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PERM_CODE = 117;
    private Button bt_start;
    private Handler handler;
    private EditText imgURl;
    private ProgressBar progressBar;
    private RelativeLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!checkExtPermission())
            requestPermission();
        bt_start = (Button) findViewById(R.id.button);
        bt_start.setOnClickListener(this);
        imgURl = (EditText) findViewById(R.id.imgURL);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String res = msg.getData().getString("state");
                if (res != null && res.toUpperCase().equals("URLNOTFOUND")) {
                    Toast.makeText(MainActivity.this, "Image not Found", Toast.LENGTH_SHORT).show();
                } else
                    progressBar.incrementProgressBy(10);
            }
        };
    }

    @Override
    public void onClick(View v) {
        startDownload();
    }

    private void startDownload() {
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int responseCode = -1;
                HttpURLConnection con;
                Bundle bundle = new Bundle();
                Message message = new Message();
                try {
                    String complete_URL = imgURl.getText().toString();
                    URL url = new URL(complete_URL);
                    con = (HttpURLConnection) url.openConnection();
                    con.connect();
                    responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        final String filename = complete_URL.substring(complete_URL.lastIndexOf("/") + 1);
                        InputStream in = con.getInputStream();
                        final Bitmap bm = BitmapFactory.decodeStream(in);
                        for (int i = 0; i < 10; i++) {
                            Thread.sleep(1000);
                            handler.sendMessage(handler.obtainMessage());
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                File Folder = Environment.getExternalStorageDirectory();
                                File myFile = new File(Folder, filename);
                                FileOutputStream outputStream = null;
                                try {
                                    outputStream = new FileOutputStream(myFile);
                                    bm.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                                } catch (final FileNotFoundException e) {
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(MainActivity.this, "Error in Creating File:" + e, Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                    e.printStackTrace();
                                }
                                if (outputStream != null)
                                    try {
                                        outputStream.close();
                                    } catch (final IOException e) {
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(MainActivity.this, "Error in Closing File:" + e, Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        e.printStackTrace();
                                    }
                                Toast.makeText(MainActivity.this, "Image Downloaded Successfully and Saved in SD Card", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        bundle.putString("state", "URLNOTFOUND");
                        message.setData(bundle);
                        handler.sendMessage(message);
                    }

                } catch (MalformedURLException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Invalid URL", Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                } catch (IOException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Connection Lost", Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public boolean checkExtPermission() {
        int writeRes = ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE);
        int readRes = ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE);
        return ((writeRes == PackageManager.PERMISSION_GRANTED) && (readRes == PackageManager.PERMISSION_GRANTED));
    }

    public void requestPermission() {
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
                        Snackbar.make(container, "Permission Granted.You can now download the Image", Snackbar.LENGTH_LONG).show();
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
        new AlertDialog.Builder(this)
                .setMessage(s)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }
}
