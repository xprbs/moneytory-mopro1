package com.panduprabs.moneytory;

import static android.app.DownloadManager.COLUMN_ID;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "moneytory.db";

    private static final String TABLE_USERS = "users";
    private static final String TABLE_TRX = "trx";

    static final String KEY_ID = "id";
    static final String KEY_AMOUNT = "amount";
    static final String KEY_DESC = "deskripsi";
    static final String KEY_DATE = "tgl";
    static final String KEY_CATEGORY = "category";

    private static final String CREATE_TABLE_USERS = "CREATE TABLE " +
            TABLE_USERS +
            "(" +
            "id INTEGER NOT NULL PRIMARY KEY," +
            "full_name TEXT," +
            "username TEXT," +
            "password TEXT" +
            ")";

    private static final String CREATE_TABLE_TRX = "CREATE TABLE " +
            TABLE_TRX +
            "(" +
            "id INTEGER NOT NULL PRIMARY KEY, " +
            "amount INTEGER, " +
            "deskripsi TEXT, " +
            "tgl TEXT," +
            "category TEXT)";

    DBHelper(@Nullable Context context){
        super(context, DB_NAME, null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL(CREATE_TABLE_USERS);
        MyDB.execSQL(CREATE_TABLE_TRX);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        MyDB.execSQL("DROP TABLE IF EXISTS " + TABLE_TRX);

        onCreate(MyDB);

    }

    public boolean insertData(String fullname, String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name", fullname);
        contentValues.put("username", username);
        contentValues.put("password", password);

        long result = MyDB.insert(TABLE_USERS, null, contentValues);
        if (result==-1) return false;
        else
            return true;
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM users WHERE username = ?", new String[]{username});
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkUsernamePassword(String username, String password)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT * FROM "+TABLE_USERS+" WHERE username = ? and password = ?", new String[] {username, password});
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean insertTrx (Integer amount, String deskripsi, String tgl, String category){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("amount", amount);
        contentValues.put("deskripsi", deskripsi);
        contentValues.put("tgl", tgl);
        contentValues.put("category", category);

        long result = MyDB.insert(TABLE_TRX, null, contentValues);
        if (result==-1) return false;
        else
            return true;
    }


}
