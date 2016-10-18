package com.android.developer.learn_android_acadgild;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.developer.learn_android_acadgild.Database.DBHelper;
import com.android.developer.learn_android_acadgild.Utils.Constants;
import com.android.developer.learn_android_acadgild.adapter.CustomDataAdapter;

public class MainActivity extends AppCompatActivity {
    private DBHelper db;
    private String fName[] = {"X", "Y", "Z", "W"};
    private String lName[] = {"X", "Y", "Z", "W"};
    private ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = DBHelper.getInstance(this);

        int count = db.getFullCount(Constants.TABLE, null);

        if (count > 0) {
            db.deleteRecords(Constants.TABLE, null, null);
            insertRecord();
        } else {
            insertRecord();
        }

        listview = (ListView) findViewById(R.id.dataList);
        listview.setAdapter(new CustomDataAdapter(this, db.getAllDatas()));
    }

    private void insertRecord() {
        for (int i = 0; i < fName.length; i++) {
            ContentValues values = new ContentValues();
            values.put(Constants.ID, i + 1);
            values.put(Constants.FIRST_NAME, fName[i]);
            values.put(Constants.LAST_NAME, lName[i]);
            db.insertContentVals(Constants.TABLE, values);
        }
    }
}
