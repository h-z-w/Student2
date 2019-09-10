package com.example.student.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.student.R;
import com.example.student.entity.Insert;

import java.util.List;

public class InsertAdapter extends BaseAdapter {
    private List<Insert> inserts;
    private int selectItem=-1;



    public InsertAdapter(List<Insert> inserts) {
        this.inserts = inserts;
    }

    @Override
    public int getCount() {
        return inserts.size();
    }

    @Override
    public Object getItem(int i) {
        return inserts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
            holder = new ViewHolder();

            holder.name = convertView.findViewById(R.id.btn_name);
            holder.classname = convertView.findViewById(R.id.btn_class);
            holder.age = convertView.findViewById(R.id.btn_old);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Insert insert = inserts.get(position);
        holder.name.setText(insert.getName());
        holder.classname.setText(insert.getClass_mate());
        holder.age.setText(String.valueOf(insert.getAge()));


        if (selectItem == position){
            convertView.setBackgroundColor(Color.YELLOW);
        }
        else {
            convertView.setBackgroundColor(Color.TRANSPARENT);
        }
        return convertView;
    }
    static class ViewHolder {
        TextView name;
        TextView classname;
        TextView age;

    }

    public void setSelectItem(int selectItem){
        this.selectItem = selectItem;
    }
}
