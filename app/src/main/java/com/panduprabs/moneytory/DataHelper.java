package com.panduprabs.moneytory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "moneytory.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_TALL = "talls";

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table transaction(no integer primary key, amount integer null, desc text null, category text null, tgl text null)";
        Log.d("Data", "onCreate: "+sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TALL);
        onCreate(db);
    }


}
