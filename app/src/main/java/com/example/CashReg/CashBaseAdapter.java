package com.example.CashReg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CashBaseAdapter extends android.widget.BaseAdapter {
    Context context;
    ArrayList<Productlist> mylist;
    //need Array list
    //layout inflater for showing list
    // cashabseadaptor constructor to get array list here from other class.
    public CashBaseAdapter(Context context, ArrayList<Productlist> mylist) {
        this.context = context;
        this.mylist = mylist;
    }
    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView = LayoutInflater.from(context).inflate(R.layout.list_row_layout,null);
       TextView prodname = convertView.findViewById(R.id.productid);
       TextView qty = convertView.findViewById(R.id.quantityid);
       TextView price = convertView.findViewById(R.id.priceid);
       prodname.setText(mylist.get(position).getProductname());
       qty.setText(mylist.get(position).getQuantity()+"");
       price.setText(mylist.get(position).getPrice()+"");
       return convertView;
    }

}
