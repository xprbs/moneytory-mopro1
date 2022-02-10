package com.panduprabs.moneytory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddIncome extends AppCompatActivity {

    EditText jumlah, descr, datee;
    Button save;
    String category;

    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        jumlah = (EditText) findViewById(R.id.InputAmountIncome);
        descr = (EditText) findViewById(R.id.InputDescIncome);
        datee = (EditText) findViewById(R.id.InputDateIncome);
        save = (Button) findViewById(R.id.buttonSaveIncome);

        DB = new DBHelper(this);

        category = "income";

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer amount = Integer.parseInt(jumlah.getText().toString());
//                Integer amount = Integer.parseInt(mentahjumlah);
                String deskripsi = descr.getText().toString();
                String tgl = datee.getText().toString();
                category = "income";

//                Log.v("Jumlah : ", amount.toString());
//                Log.v("Deskripsi : ", deskripsi);
//                Log.v("Tanggal : ", tgl);
//                Log.v("Kategori", category);


                if (amount.equals("") || deskripsi.equals("") || tgl.equals("")){
                    Toast.makeText(AddIncome.this, "Please fill all the form", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(AddIncome.this, "Ga Kosong", Toast.LENGTH_SHORT).show();
                    Boolean simpan = DB.insertTrx(amount, deskripsi, tgl, category);
                    if (simpan==true){
                        Toast.makeText(AddIncome.this, "Add Income Data Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddIncome.this, HomeActivity.class));
                    }else{
                        Toast.makeText(AddIncome.this, "Add Income Data Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}