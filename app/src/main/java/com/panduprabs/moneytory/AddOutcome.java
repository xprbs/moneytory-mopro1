package com.panduprabs.moneytory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddOutcome extends AppCompatActivity {

    EditText jumlah, descr, datee;
    Button save;
    String category;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_outcome);

        jumlah = (EditText) findViewById(R.id.InputAmountOutcome);
        descr = (EditText) findViewById(R.id.InputDescOutcome);
        datee = (EditText) findViewById(R.id.InputDateOutcome);
        save = (Button) findViewById(R.id.buttonSaveOutcome);

        DB = new DBHelper(this);

        category = "outcome";

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer amount = Integer.parseInt(jumlah.getText().toString());
//                Integer amount = Integer.parseInt(mentahjumlah);
                String deskripsi = descr.getText().toString();
                String tgl = datee.getText().toString();
                category = "outcome";


                if (amount.equals("") || deskripsi.equals("") || tgl.equals("")){
                    Toast.makeText(AddOutcome.this, "Please fill all the form", Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(AddIncome.this, "Ga Kosong", Toast.LENGTH_SHORT).show();
                    Boolean simpan = DB.insertTrx(amount, deskripsi, tgl, category);
                    if (simpan==true){
                        Toast.makeText(AddOutcome.this, "Add Income Data Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddOutcome.this, HomeActivity.class));
                    }else{
                        Toast.makeText(AddOutcome.this, "Add Income Data Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}