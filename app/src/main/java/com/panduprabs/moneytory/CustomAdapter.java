package com.panduprabs.moneytory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList id_trx, amount_trx, desc_trx, date_trx;

    CustomAdapter(Context context, ArrayList id_trx, ArrayList amount_trx, ArrayList desc_trx, ArrayList date_trx){
        this.context = context;
        this.id_trx = id_trx;
        this.amount_trx = amount_trx;
        this.desc_trx = desc_trx;
        this.date_trx = date_trx;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.desctrx.setText(String.valueOf(desc_trx.get(position)));
        holder.datetrx.setText(String.valueOf(date_trx.get(position)));
        holder.amountrx.setText(String.valueOf(amount_trx.get(position)));

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView desctrx, datetrx, amountrx;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            desctrx = itemView.findViewById(R.id.titletrxtext);
            datetrx = itemView.findViewById(R.id.datetrxtext);
            amountrx = itemView.findViewById(R.id.amounttrxtext);
        }
    }

}
