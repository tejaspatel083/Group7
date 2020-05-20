package com.example.group7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NameAdapter extends BaseAdapter {

    private ArrayList<NameList> arrayList;
    private TextView name;

    public NameAdapter(ArrayList<NameList> arrayList) {

        this.arrayList = arrayList;

    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.arrayadapter,parent,false);
        name = convertView.findViewById(R.id.textname);
        name.setText(arrayList.get(position).getName());
        return convertView;
    }
}
