package com.android.developer.learn_android_acadgild.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.developer.learn_android_acadgild.Utils.Constants;

/**
 * Created by karthik90 on 10/17/2016.
 */

public class ProductClass extends SQLiteOpenHelper {
    private Context context;

    public ProductClass(Context context, String DatabaseName, String nullColumnHack, int databaseVersion) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE IF NOT EXISTS " + Constants.PRODUCT_RECORD + " ("
                + Constants.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Constants.PRODUCT_NAME + " TEXT) ";
        db.execSQL(table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        context.deleteDatabase(Constants.DATABASE_NAME);
        onCreate(db);

    }
}

