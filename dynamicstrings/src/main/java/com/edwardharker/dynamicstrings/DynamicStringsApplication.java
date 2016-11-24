package com.edwardharker.dynamicstrings;

import android.app.Application;
import android.content.Context;

public class DynamicStringsApplication extends Application {

    private final DynamicStrings dynamicStrings = new DynamicStrings();

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(dynamicStrings.wrap(base));
    }

    @Override
    public Object getSystemService(String name) {
        return dynamicStrings.isSystemService(name) ? dynamicStrings : super.getSystemService(name);
    }

    /**
     * @return the application's instance of DynamicStrings
     */
    public DynamicStrings dynamicStrings() {
        return dynamicStrings;
    }
}
