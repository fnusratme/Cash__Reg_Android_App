package com.example.CashReg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity implements HistoryAdapter.listClickListener{
 RecyclerView historyRecyclerview;
 TextView historytextview;
 ArrayList<HistoryList> myhistorylist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent frommangerintent = getIntent();
        historytextview = findViewById(R.id.historytextView);
        historytextview.setVisibility(View.INVISIBLE);
        historyRecyclerview = findViewById(R.id.historyRecyclerview);
        historyRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        if(!(this.getIntent().getExtras().getParcelableArrayList("forhistroryActivity").isEmpty()))
        {
            myhistorylist = this.getIntent().getExtras().getParcelableArrayList("forhistroryActivity");
            HistoryAdapter adapter = new HistoryAdapter(this, myhistorylist);
            adapter.listener = this;
            historyRecyclerview.setAdapter(adapter);
        }
        else {System.out.println("Empty History");
           historytextview.setText("NO PURCHASE HISTORY");
           historytextview.setVisibility(View.VISIBLE);
           historyRecyclerview.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onHistorySelected(HistoryList selectedHistory) {
        openDetailedHistory(selectedHistory);
    }
    private void openDetailedHistory(HistoryList selectedHistory){
          Intent detailedintent = new Intent(this, DetailHistoryActivity.class);
          detailedintent.putExtra("dethistory",selectedHistory);
         startActivity(detailedintent);

    }
}
