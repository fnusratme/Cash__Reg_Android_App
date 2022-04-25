package com.example.CashReg;

import android.os.Parcel;
import android.os.Parcelable;

public class Productlist implements Parcelable {
   String productname;
   int quantity;
    double price;


    public Productlist(String productname, int quantity, double price) {
        this.productname = productname;
        this.quantity = quantity;
        this.price = price;
    }

    protected Productlist(Parcel in) {
        productname = in.readString();
        quantity = in.readInt();
        price = in.readDouble();
    }

    public static final Creator<Productlist> CREATOR = new Creator<Productlist>() {
        @Override
        public Productlist createFromParcel(Parcel in) {
            return new Productlist(in);
        }

        @Override
        public Productlist[] newArray(int size) {
            return new Productlist[size];
        }
    };

    public Productlist() {

    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toString(){
        return "[" + productname + "," + quantity + "," + price+ "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productname);
        dest.writeInt(quantity);
        dest.writeDouble(price);
    }
}
