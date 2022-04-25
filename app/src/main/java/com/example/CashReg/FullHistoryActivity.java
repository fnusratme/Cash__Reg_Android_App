package com.example.CashReg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FullHistoryActivity extends AppCompatActivity {
     TextView detailprodname;
     TextView detailprice;
     TextView detaildate;
     HistoryList histobj;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_history);
        detailprodname = findViewById(R.id.detprodname);
        detailprice = findViewById(R.id.detprice);
        detaildate = findViewById(R.id.detdate);
        Intent fromhistoryintent = getIntent();
       histobj = this.getIntent().getParcelableExtra("dethistory");
            detailprodname.setText("Product :"+histobj.getProductname());
            detailprice.setText("Price :"+histobj.getTotal());
            detaildate.setText("Purchase Date: " +histobj.getDate());

    }
}