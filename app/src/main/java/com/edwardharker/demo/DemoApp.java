package com.edwardharker.demo;

import com.edwardharker.dynamicstrings.DynamicStringsApplication;

import java.io.IOException;

public class DemoApp extends DynamicStringsApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            dynamicStrings().loadStrings(getAssets().open("demo-strings.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
