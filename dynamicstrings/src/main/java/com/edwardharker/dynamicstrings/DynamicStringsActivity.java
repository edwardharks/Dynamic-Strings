package com.edwardharker.dynamicstrings;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;

public class DynamicStringsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), dynamicStrings().layoutInflaterFactory(getDelegate()));
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), dynamicStrings().layoutInflaterFactory(getDelegate()));
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(dynamicStrings(base).wrap(base));
    }

    @Override
    public Object getSystemService(String name) {
        DynamicStrings dynamicStrings = dynamicStrings();
        return dynamicStrings.isSystemService(name) ? dynamicStrings : super.getSystemService(name);
    }

    public DynamicStrings dynamicStrings() {
        return dynamicStrings(this);
    }

    private DynamicStrings dynamicStrings(Context context) {
        //noinspection WrongConstant
        return (DynamicStrings) context.getApplicationContext().getSystemService(DynamicStrings.DYNAMIC_STRINGS_SERVICE);
    }

}
