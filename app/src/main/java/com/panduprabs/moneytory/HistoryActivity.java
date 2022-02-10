package com.panduprabs.moneytory;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    DBHelper DB;
    ArrayList<String> id, desc_trx, amount_trx, date_trx;
}
