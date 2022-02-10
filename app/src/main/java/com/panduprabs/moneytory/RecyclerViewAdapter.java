package com.panduprabs.moneytory;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList descList; //Digunakan untuk Nama
    private ArrayList amountList; //Digunakan untuk Jurusan
    private ArrayList dateList; //Digunakan untuk Jurusan

    RecyclerViewAdapter(ArrayList descList, ArrayList amountList, ArrayList dateList){
        this.descList = descList;
        this.amountList = amountList;
        this.dateList = dateList;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Desc, Amount, Date;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View untuk kita gunakan pada RecyclerView
            Desc = itemView.findViewById(R.id.titletrxtext);
            Amount = itemView.findViewById(R.id.amounttrxtext);
            Date = itemView.findViewById(R.id.datetrxtext);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        //Memanggil Nilai/Value Pada View-View Yang Telah Dibuat pada Posisi Tertentu
        final String Desc = (String) descList.get(position);//Mengambil data (Nama) sesuai dengan posisi yang telah ditentukan
        final String Amount = (String) amountList.get(position);//Mengambil data (Jurusan) sesuai dengan posisi yang telah ditentukan
        final String Date = (String) dateList.get(position);//Mengambil data (NIM) sesuai dengan posisi yang telah ditentukan
        holder.Desc.setText(Desc);
        holder.Amount.setText(Amount);
        holder.Date.setText(Date);
    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return descList.size();
    }




}