package com.panduprabs.moneytory;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Date;

public class HomeActivity extends AppCompatActivity{

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragement = new HomeFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, selectedFragement).commit();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_nav:
                        selectedFragement = new HomeFragment();
                        break;
                    case R.id.history_nav:
                        selectedFragement = new HistoryFragment();
                        break;
                    case R.id.notif_nav:
                        selectedFragement = new NotificationFragment();
                        break;
                    case R.id.logout_nav:
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragement).commit();
                return true;
            }
        });

    }



//    void storeDataInArrays(){
//        Cursor cursor = DB.readAllData();
//        if (cursor.getCount() == 0){
//            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
//        }else{
//            while (cursor.moveToNext()){
//                id_trx.add(cursor.getString(0));
//                desc_trx.add(cursor.getString(1));
//                date_trx.add(cursor.getString(2));
//                amount_trx.add(cursor.getString(3));
//
//            }
//        }
//    }

    public void addIncome(View view){
        startActivity(new Intent(HomeActivity.this, AddIncome.class));
    }

//    public void addOutcome(View view){
//        startActivity(new Intent(HomeActivity.this, AddOutcome.class));
//    }

}
