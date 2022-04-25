package com.example.CashReg;

import android.os.Parcel;
import android.os.Parcelable;

public class HistoryList extends Productlist implements Parcelable {
     private String date;
     private double total;

    public HistoryList(String productname, int quantity, double price, String date, double total) {
        super(productname, quantity, price);
        this.date = date;
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    public String toString(){
        return "[" + getProductname() + "," + getQuantity() + "," + getPrice()+"," + getDate() + "," + getTotal() +  "]";
    }
    protected HistoryList(Parcel in) {
        super(in);
        date = in.readString();
        total = in.readDouble();
    }
    public static final Creator<HistoryList> CREATOR = new Creator<HistoryList>() {
        @Override
        public HistoryList createFromParcel(Parcel in) {
            return new HistoryList(in);
        }

        @Override
        public HistoryList[] newArray(int size) {
            return new HistoryList[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest,flags);
        dest.writeString(date);
        dest.writeDouble(total);
    }


}
