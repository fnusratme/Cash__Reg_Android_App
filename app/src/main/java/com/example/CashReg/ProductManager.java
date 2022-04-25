package com.example.CashReg;

import java.util.ArrayList;

public class ProductManager {
    ArrayList<Productlist> productArray = new ArrayList<>();
    ArrayList<HistoryList> historyArray = new ArrayList<>();



    public ProductManager() {
        Productlist list1 = new Productlist("Pants",30,75);
        Productlist list2 = new Productlist("Shoes ",90,45);
        Productlist list3 = new Productlist("Shirts",300,35);
        Productlist list4 = new Productlist("Dress",300,90);
        productArray.add(list1);
        productArray.add(list2);
        productArray.add(list3);
        productArray.add(list4);

    }



//     void addtoArray(){
//    }
     void addtoHistory(String date,int position,double total,int quantity){
         String productname = productArray.get(position).getProductname();
         double price = productArray.get(position).getPrice();
         HistoryList list = new HistoryList(productname,quantity,price,date,total);
         historyArray.add(list);// contains History and each of them stored in historylist
     }
    void printhistory()
    { System.out.println(historyArray.toString()); }

    void printArray()
    { System.out.println(productArray.toString()); }
    //Check quantity
    boolean checkQuantity(int position, int userquantity){
         boolean isavailable = false;
        //System.out.println(" Quantity before calcualtion is "+userquantity );
         if(userquantity <= productArray.get(position).quantity){
             isavailable = true;
             //System.out.println("Remaining Quantity is "+productArray.get(position).quantity );
                      }
         else { isavailable = false;
             System.out.println(isavailable+"");
         }
         return isavailable;
    }
     //purchaseHistory
    boolean purchaseHistory(int position, int userquantity)
    {   boolean isvalid = true;
        if(userquantity <= productArray.get(position).quantity){
            productArray.get(position).quantity = productArray.get(position).quantity - userquantity;}
        else isvalid= false;
        return isvalid;    }
     double calculatePrice(int position, int quantity){
         double total=0;
         total = productArray.get(position).price*quantity;
         return  total;
     }

}
