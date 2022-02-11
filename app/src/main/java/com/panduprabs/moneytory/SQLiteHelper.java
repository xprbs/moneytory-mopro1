package com.panduprabs.moneytory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static String NAMA_DATABASE = "moneytory.db";

    private static final String NAMA_TABEL = "trx";

    static final String KEY_ID = "id";
    static final String KEY_AMOUNT = "amount";
    static final String KEY_DESC = "deskripsi";
    static final String KEY_DATE = "tgl";

    SQLiteHelper(@Nullable Context context) {
        super(context, NAMA_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String BUAT_TABEL = "CREATE TABLE " + NAMA_TABEL + " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_AMOUNT + " VARCHAR)";
        db.execSQL(BUAT_TABEL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABEL);
//        onCreate(db);
    }
}