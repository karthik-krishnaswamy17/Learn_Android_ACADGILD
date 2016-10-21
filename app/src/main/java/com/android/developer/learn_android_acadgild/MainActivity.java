package com.android.developer.learn_android_acadgild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_save, bt_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_save = (Button) findViewById(R.id.bt_save);
        bt_check = (Button) findViewById(R.id.bt_check);
        bt_save.setOnClickListener(this);
        bt_check.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String fileContent = "Hello this content gores into file.";
        String fileName = "myNewFile.txt";
        File checkFile;
        switch (id) {
            case R.id.bt_save:
                try {
                    FileOutputStream myFile = openFileOutput(fileName, MODE_PRIVATE);
                    myFile.write(fileContent.getBytes());
                    Toast.makeText(this, "File Saved Successfully !", Toast.LENGTH_SHORT).show();
                    myFile.close();
                } catch (FileNotFoundException e) {
                    Toast.makeText(this, "FileNotFoundException: " + e, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                } catch (IOException e) {
                    Toast.makeText(this, "IOException: " + e, Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                break;

            case R.id.bt_check:
                checkFile = new File(getFilesDir(), fileName);
                if (checkFile.exists())
                    Toast.makeText(this, "File exists ", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "File don't exists ", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
