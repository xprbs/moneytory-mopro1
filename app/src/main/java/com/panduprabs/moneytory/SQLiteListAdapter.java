package com.panduprabs.moneytory;


import android.content.Context;
import android.os.Debug;
import android.text.Layout;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.google.android.material.transition.Hold;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class SQLiteListAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<String> trx_id;
    private ArrayList<String> trx_desc;
    private ArrayList<String> trx_date;
    private ArrayList<String> trx_amount;
    private ArrayList<String> trx_category;

    private static final String INCOMESTRING = "income";
    private static final String OUTCOMESTRING = "outcome";


    SQLiteListAdapter(Context context1, ArrayList<String> ID_ArrayList, ArrayList<String> ID, ArrayList<String> DESC, ArrayList<String> DATE, ArrayList<String> AMOUNT, ArrayList<String> CATEGORY){
        this.context = context1;
        this.trx_id = ID;
        this.trx_desc = DESC;
        this.trx_date = DATE;
        this.trx_amount = AMOUNT;
        this.trx_category = CATEGORY;
    }

    public class Holder{
        TextView textView_id;
        TextView textView_desc;
        TextView textView_date;
        TextView textView_amount;
        ImageView icon_stats;

    }

    @Override
    public int getCount(){
        return trx_id.size();
    }

    @Override
    public Object getItem(int position){
        return null;
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Holder holder;
        LayoutInflater inflater;

        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);

            holder = new Holder();
            holder.textView_desc = convertView.findViewById(R.id.titletrxtext);
            holder.textView_date = convertView.findViewById(R.id.datetrxtext);
            holder.textView_amount = convertView.findViewById(R.id.amounttrxtext);
            holder.icon_stats = convertView.findViewById(R.id.iconStats);


            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        if (trx_category.get(position).equals("income")){
            holder.textView_desc.setText(trx_desc.get(position));
            holder.textView_date.setText(trx_amount.get(position));
            holder.textView_amount.setText("Rp. "+trx_date.get(position));
            holder.icon_stats.setImageResource(R.drawable.trx_in);
            holder.textView_amount.setTextColor(ContextCompat.getColor(context, R.color.textGreen));
        }else{
            holder.textView_desc.setText(trx_desc.get(position));
            holder.textView_date.setText(trx_amount.get(position));
            holder.textView_amount.setText("Rp. "+trx_date.get(position));
            holder.icon_stats.setImageResource(R.drawable.trx_out);
            holder.textView_amount.setTextColor(ContextCompat.getColor(context, R.color.textRed));
        }

        return convertView;
    }






}
