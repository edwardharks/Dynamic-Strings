package com.edwardharker.dynamicstrings;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

final class DynamicStringsViewCreator {

    @Nullable
    View createView(String name, Context context, AttributeSet attrs) {
        if ("TextView".equals(name)) {
            return new DynamicStringsTextView(context, attrs);
        }
        return null;
    }
}
