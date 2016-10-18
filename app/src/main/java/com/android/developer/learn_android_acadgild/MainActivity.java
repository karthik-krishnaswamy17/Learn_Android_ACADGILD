package com.android.developer.learn_android_acadgild;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.developer.learn_android_acadgild.Utils.Constants;
import com.android.developer.learn_android_acadgild.database.DBHelper;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    byte[] image;
    private DBHelper db;
    private String[] employeeName = {"karthik"};
    private int[] employeeAge = {26};
    private int[] employeePhoto = {R.drawable.employee1};
    private TextView textName, textAge;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = DBHelper.getInstance(this);
        int count = db.getFullCount(Constants.EMPLOYEE_RECORD, null);
        if (count == 0)
            insertEmployeeRecord();
        else {
            db.deleteRecords(Constants.EMPLOYEE_RECORD, null, null);
            insertEmployeeRecord();
        }
        textName = (TextView) findViewById(R.id.name);
        textAge = (TextView) findViewById(R.id.age);
        imageView = (ImageView) findViewById(R.id.employeePhoto);

        textName.setText(db.getValue(Constants.EMPLOYEE_RECORD, Constants.EMPLOYEE_NAME, Constants.EMPLOYEE_ID + "=0"));
        textAge.setText(db.getValue(Constants.EMPLOYEE_RECORD, Constants.EMPLOYEE_AGE, Constants.EMPLOYEE_ID + "=0"));
        Cursor c = db.getTableRecords(Constants.EMPLOYEE_RECORD, new String[]{Constants.EMPLOYEE_PHOTO}, Constants.EMPLOYEE_ID + "=0", null);

        if (c != null) {
            c.moveToFirst();
            do {
                image = c.getBlob(c.getColumnIndex(Constants.EMPLOYEE_PHOTO));
            } while (c.moveToNext());
            Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
            imageView.setImageBitmap(bmp);
        }
    }


    private void insertEmployeeRecord() {
        ContentValues values = new ContentValues();
        values.put(Constants.EMPLOYEE_NAME, employeeName[0]);
        values.put(Constants.EMPLOYEE_AGE, employeeAge[0]);
        Bitmap photo = BitmapFactory.decodeResource(getResources(), employeePhoto[0]);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        photo.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] bArray = bos.toByteArray();
        values.put(Constants.EMPLOYEE_PHOTO, bArray);
        values.put(Constants.EMPLOYEE_ID, 0);
        db.insertContentVals(Constants.EMPLOYEE_RECORD, values);

    }
}
