package com.edwardharker.dynamicstrings;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;


final class DynamicStringsContextWrapper extends ContextWrapper {

    private final DynamicStringsResources resources;

    static Context wrap(Context context, DynamicStrings dynamicStrings) {
        return new DynamicStringsContextWrapper(context, dynamicStrings);
    }

    private DynamicStringsContextWrapper(Context base, DynamicStrings dynamicStrings) {
        super(base);
        resources = new DynamicStringsResources(base.getResources(), dynamicStrings);
    }

    @Override
    public Resources getResources() {
        return resources;
    }
}
