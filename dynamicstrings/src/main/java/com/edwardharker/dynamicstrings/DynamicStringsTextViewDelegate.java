package com.edwardharker.dynamicstrings;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public final class DynamicStringsTextViewDelegate {

    private final TextView textView;
    private final Context context;

    public DynamicStringsTextViewDelegate(@Nullable DynamicStrings dynamicStrings, TextView textView, AttributeSet set) {
        this.textView = textView;
        this.context = wrapContext(dynamicStrings, textView.getContext());

        int[] attrs = {android.R.attr.text};
        TypedArray a = context.obtainStyledAttributes(set, attrs);
        TypedValue typedValue = a.peekValue(0);
        if (typedValue != null && typedValue.resourceId != 0) {
            textView.setText(context.getResources().getText(typedValue.resourceId));
        }
        a.recycle();
    }

    public void setText(@StringRes int id) {
        textView.setText(context.getString(id));
    }

    private Context wrapContext(DynamicStrings dynamicStrings, Context context) {
        if (dynamicStrings != null) {
            return dynamicStrings.wrap(context);
        }
        return context;
    }
}
