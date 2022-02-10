package com.panduprabs.moneytory;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TransactionActivity extends SQLiteOpenHelper {

    public static final String DB_NAME = "moneytory.db";

    public TransactionActivity (Context context){
        super(context, "moneytory.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE trx (id INTEGER NOT NULL PRIMARY KEY, amount INTEGER, deskripsi TEXT, tgl TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS trx");
    }

//    public Boolean insertTrx (Integer amount, String deskripsi, String tgl){
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("amount", amount);
//        contentValues.put("deskripsi", deskripsi);
//        contentValues.put("tgl", tgl);
//
//        long result = MyDB.insert("trx", null, contentValues);
//        if (result==-1) return false;
//        else
//            return true;
//    }

//    public void saveIncome(){
//        amount = (EditText) findViewById(R.id.InputAmountIncome);
//        deskripsi = (EditText) findViewById(R.id.InputDescIncome);
//        tgl = (EditText) findViewById(R.id.InputDateIncome);
//        save = (Button) findViewById(R.id.buttonSaveIncome);
//        category = "income";
//
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String mentahjumlah = amount.getText().toString();
//                Integer jumlah = Integer.parseInt(mentahjumlah);
//                String desc = deskripsi.getText().toString();
//                String date = tgl.getText().toString();
//
//                if (amount.equals("") || deskripsi.equals("") || tgl.equals("")){
//                    Toast.makeText(TransactionActivity.this, "Please fill all the form", Toast.LENGTH_SHORT).show();
//                }else{
//                    Boolean saveincome = DB.insertTrx(jumlah, desc, date, category);
//                    if (saveincome==true){
//                        Toast.makeText(TransactionActivity.this, "Add Income Data Success", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(TransactionActivity.this, HomeActivity.class));
//                    }else{
//                        Toast.makeText(TransactionActivity.this, "Add Income Data Failed", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//    }
//
//    public void saveOutcome(){
//        amount = (EditText) findViewById(R.id.InputAmountOutcome);
//        deskripsi = (EditText) findViewById(R.id.InputDescOutcome);
//        tgl = (EditText) findViewById(R.id.InputDateOutcome);
//        save = (Button) findViewById(R.id.buttonSaveIncome);
//        category = "outcome";
//
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String mentahjumlah = amount.getText().toString();
//                Integer jumlah = Integer.parseInt(mentahjumlah);
//                String desc = deskripsi.getText().toString();
//                String date = tgl.getText().toString();
//
//                if (amount.equals("") || deskripsi.equals("") || tgl.equals("")){
//                    Toast.makeText(TransactionActivity.this, "Please fill all the form", Toast.LENGTH_SHORT).show();
//                }else{
//                    Boolean saveincome = DB.insertTrx(jumlah, desc, date, category);
//                    if (saveincome==true){
//                        Toast.makeText(TransactionActivity.this, "Add Income Data Success", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(TransactionActivity.this, HomeActivity.class));
//                    }else{
//                        Toast.makeText(TransactionActivity.this, "Add Income Data Failed", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//    }





}
