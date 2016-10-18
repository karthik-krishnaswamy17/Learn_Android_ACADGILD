package com.android.developer.learn_android_acadgild.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.developer.learn_android_acadgild.Utils.Constants;

/**
 * Created by karthik90 on 10/18/2016.
 */

public class EmployeeTable extends SQLiteOpenHelper {
    Context context;

    public EmployeeTable(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE IF NOT EXISTS " + Constants.EMPLOYEE_RECORD + " ("
                + Constants.EMPLOYEE_ID + " INTEGER PRIMARY KEY,"
                + Constants.EMPLOYEE_NAME + " TEXT,"
                + Constants.EMPLOYEE_AGE + " INTEGER,"
                + Constants.EMPLOYEE_PHOTO + " BLOB)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        context.deleteDatabase(Constants.DATABASE_NAME);
        onCreate(db);

    }
}
