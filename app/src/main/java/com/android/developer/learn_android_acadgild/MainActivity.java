package com.android.developer.learn_android_acadgild;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_saveImage, bt_loadImage;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_saveImage = (Button) findViewById(R.id.bt_saveImage);
        bt_loadImage = (Button) findViewById(R.id.bt_LoadImage);
        img = (ImageView) findViewById(R.id.img);
        bt_saveImage.setOnClickListener(this);
        bt_loadImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) == true) {
            processImage(v.getId());
        } else
            Toast.makeText(this, "SD CARD is not Available", Toast.LENGTH_SHORT).show();

    }

    private void processImage(int id) {
        String folder = "Resources", filename = "img.jpg";
        switch (id) {

            case R.id.bt_saveImage: {
                try {
                    Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
                    File Folder = Environment.getExternalStoragePublicDirectory(folder);
                    if (!Folder.exists())
                        Folder.mkdir();
                    File myFile = new File(Folder, filename);
                    FileOutputStream outputStream = new FileOutputStream(myFile);
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        Toast.makeText(this, "FileOutputStream Exception:" + e, Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    Toast.makeText(this, "Image saved successfully on:" + myFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    Toast.makeText(this, "Exception:" + e, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                } catch (IOException e) {
                    Toast.makeText(this, "Exception:" + e, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                break;
            }

            case R.id.bt_LoadImage: {
                try {
                    File myFile = new File(Environment.getExternalStorageDirectory() + "/" + folder + "/" + filename);
                    FileInputStream fi = new FileInputStream(myFile);
                    if (myFile.exists()) {
                        Bitmap mp = BitmapFactory.decodeFile(myFile.getAbsolutePath());
                        img.setImageBitmap(mp);
                        Toast.makeText(this, "File Loaded Successfully:" + myFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                        fi.close();
                    }
                } catch (FileNotFoundException e) {
                    Toast.makeText(this, "FileNotFoundException:" + e, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                } catch (IOException e) {
                    Toast.makeText(this, "IOException:" + e, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                break;
            }

        }


    }
}
