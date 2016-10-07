package com.android.developer.learn_android_acadgild;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by karthik90 on 10/6/2016.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int IMG_REQ = 1;
    Button bt_gallery;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_gallery = (Button) findViewById(R.id.bt_gallery);
        bt_gallery.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, IMG_REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMG_REQ && resultCode == RESULT_OK && data != null) {
            ImageView img = (ImageView) findViewById(R.id.img);
            img.setVisibility(ImageView.VISIBLE);
            Uri uri = data.getData();
            Bitmap photo;
            try {
                photo = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                img.setImageBitmap(photo);
                Toast.makeText(this, "Image Loaded Successfully", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

        }
    }
}
