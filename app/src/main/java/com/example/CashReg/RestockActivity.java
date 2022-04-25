package com.example.CashReg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class RestockActivity extends AppCompatActivity {
 Button save;
 Button cancel;
 ListView list_view;
 EditText editText;
 CashBaseAdapter adapter;
 int userQnty;
 int selectedPosition;
 ArrayList<Productlist> stocklist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);
        list_view = findViewById(R.id.stocklist);
        editText = findViewById(R.id.edittext);
        stocklist =((myApp)getApplication()).getManager().productArray;
        System.out.println("My Stocklist :" +((myApp)getApplication()).getManager().productArray);
        adapter = new CashBaseAdapter(this,stocklist);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
            }
        });

    }


    public void Cancelclicked(View view) {
        Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
    }

    public void saveClicked(View view) {
        if(editText.getText().toString().isEmpty())
                {
                    Toast.makeText(this, "All fields are Required", Toast.LENGTH_SHORT).show();
                }
                else{
                    userQnty = Integer.parseInt(editText.getText().toString());
                    int oldqnty = stocklist.get(selectedPosition).getQuantity();
                    int newqnty = userQnty+oldqnty;
                    stocklist.get(selectedPosition).setQuantity(newqnty);
                    adapter.notifyDataSetChanged();
                }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}