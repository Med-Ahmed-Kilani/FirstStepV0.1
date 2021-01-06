package com.example.firststepv01;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LogAdapter extends BaseAdapter {
    private Context context;
    private int resource;
    private ArrayList<Log> data;
    public LogAdapter(Context c, int resource, ArrayList<Log> data){
        this.context = c;
        this.data = data;
        this.resource = resource;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Log getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= convertView;
        if (v==null){
            v = LayoutInflater.from(context).inflate(R.layout.log_model,null, false);
        }



        return v;
    }
}
