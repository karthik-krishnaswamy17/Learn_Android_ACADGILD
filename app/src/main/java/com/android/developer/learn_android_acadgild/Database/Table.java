package com.android.developer.learn_android_acadgild.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.android.developer.learn_android_acadgild.Utils.Constants;

/**
 * Created by karthik90 on 10/18/2016.
 */

public class Table extends SQLiteOpenHelper {
    private Context context;

    public Table(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String query = "CREATE TABLE IF NOT EXISTS " + Constants.TABLE + "(" +
                Constants.ID + " INTEGER PRIMARY KEY," +
                Constants.FIRST_NAME + " TEXT," +
                Constants.LAST_NAME + " TEXT)";

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "onUpgrade inside ", Toast.LENGTH_SHORT).show();
        context.deleteDatabase(Constants.DATABASE_NAME);
        onCreate(db);
    }
}
