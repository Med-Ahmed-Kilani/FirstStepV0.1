package com.example.firststepv01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LogAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<Log> logs;
    public LogAdapter(@NonNull Context context, int resource, ArrayList<Log> logs) {
        super(context, resource, logs);
        this.context = context;
        this.logs = logs;
        this.resource = resource;
    }

    public class ViewHolder{
        TextView text, date;
    }

    @Override
    public int getCount(){
        return logs.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        ViewHolder viewHolder;
        if (row==null){
            row = LayoutInflater.from(getContext()).inflate(R.layout.log_model, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.date = row.findViewById(R.id.dateOfLog);
            viewHolder.text = row.findViewById(R.id.logText);
            row.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) row.getTag();
        }

        viewHolder.text.setText(logs.get(position).text);
        viewHolder.date.setText(logs.get(position).date);

        return row;
    }
}
