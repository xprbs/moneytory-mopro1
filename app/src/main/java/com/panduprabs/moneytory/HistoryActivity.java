package com.panduprabs.moneytory;


import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HistoryActivity extends AppCompatActivity {

    SQLiteDatabase SQLITEDATABASE;
    DBHelper SQLITEHELPER = new DBHelper(this);
    SQLiteListAdapter ListAdapter;

    Cursor cursor;

    ArrayList<String> ID_ArrayList = new ArrayList<>();
    ArrayList<String> DESC_ArrayList = new ArrayList<>();
    ArrayList<String> DATE_ArrayList = new ArrayList<>();
    ArrayList<String> AMOUNT_ArrayList = new ArrayList<>();
    ArrayList<String> CATEGORY_ArrayList = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listView = findViewById(R.id.list);
//        SQLITEHELPER = new SQLiteHelper(this);
    }

    @Override
    protected void onResume(){
        TampilSQLiteDBData();
        super.onResume();
    }

    private void TampilSQLiteDBData(){
        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();
        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM trx", null);

        ID_ArrayList.clear();
        DESC_ArrayList.clear();
        DATE_ArrayList.clear();
        AMOUNT_ArrayList.clear();
        CATEGORY_ArrayList.clear();

        if (cursor.moveToFirst()){
            do {
                ID_ArrayList.add(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.KEY_ID)));
                DESC_ArrayList.add(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.KEY_DESC)));
                DATE_ArrayList.add(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.KEY_DATE)));
                AMOUNT_ArrayList.add(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.KEY_AMOUNT)));
                CATEGORY_ArrayList.add(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.KEY_CATEGORY)));

            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(HistoryActivity.this, CATEGORY_ArrayList, ID_ArrayList, DESC_ArrayList, AMOUNT_ArrayList, DATE_ArrayList, CATEGORY_ArrayList);
        listView.setAdapter(ListAdapter);
        cursor.close();
    }



}
