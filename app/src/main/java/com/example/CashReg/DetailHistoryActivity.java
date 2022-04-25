package com.example.CashReg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailHistoryActivity extends AppCompatActivity {
     TextView detailprodname;
     TextView detailprice;
     TextView detaildate;
     HistoryList historyobj;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_history);
        detailprodname = findViewById(R.id.detprodname);
        detailprice = findViewById(R.id.detprice);
        detaildate = findViewById(R.id.detdate);
        Intent fromhistoryintent = getIntent();
       historyobj = this.getIntent().getParcelableExtra("dethistory");
            detailprodname.setText("Product :"+ historyobj.getProductname());
            detailprice.setText("Price :"+ historyobj.getTotal());
            detaildate.setText("Purchase Date: " + historyobj.getDate());

    }
}