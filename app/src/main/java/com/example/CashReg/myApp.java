package com.example.CashReg;

import android.app.Application;

public class myApp extends Application {
    private ProductManager manager = new ProductManager();

    public ProductManager getManager() {
        return manager;
    }
}
