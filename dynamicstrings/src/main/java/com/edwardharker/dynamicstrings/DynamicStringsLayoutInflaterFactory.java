package com.edwardharker.dynamicstrings;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;

final class DynamicStringsLayoutInflaterFactory implements LayoutInflaterFactory {

    private final AppCompatDelegate appCompatDelegate;
    private final DynamicStrings dynamicStrings;

    DynamicStringsLayoutInflaterFactory(AppCompatDelegate appCompatDelegate, DynamicStrings dynamicStrings) {
        this.appCompatDelegate = appCompatDelegate;
        this.dynamicStrings = dynamicStrings;
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = dynamicStrings.createView(name, context, attrs);
        return view != null ? view : appCompatDelegate.createView(parent, name, context, attrs);
    }
}
