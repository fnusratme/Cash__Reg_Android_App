package com.example.CashReg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.viewHolder>  {
   Context context;
   ArrayList<HistoryList> mylist;
   public interface listClickListener{
     void onHistorySelected(HistoryList selectedHistory);
   }
   public listClickListener listener;
    public static class viewHolder extends RecyclerView.ViewHolder{
        private final TextView prodname;
        private  final TextView quantity;
        private final TextView price;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            prodname = itemView.findViewById(R.id.hproductid);
            quantity = itemView.findViewById(R.id.hquantityid);
            price = itemView.findViewById(R.id.hpriceid);
        }

        public TextView getProdname() { //getters for elements in innerclass
            return prodname;
        }

        public TextView getQuantity() {
            return quantity;
        }

        public TextView getPrice() {
            return price;
        }
    }
    HistoryAdapter(Context c, ArrayList<HistoryList> list){
          context = c;
          mylist = list;
    }
    @NonNull
    @Override
    public HistoryAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_row_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.getProdname().setText(mylist.get(position).getProductname());
        holder.getQuantity().setText(mylist.get(position).getQuantity()+"");
        holder.getPrice().setText(mylist.get(position).getTotal()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onHistorySelected(mylist.get(position));
            }
        });
            }
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
}
