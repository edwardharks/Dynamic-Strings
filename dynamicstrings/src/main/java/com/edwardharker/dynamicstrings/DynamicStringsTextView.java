package com.edwardharker.dynamicstrings;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

import static com.edwardharker.dynamicstrings.DynamicStrings.DYNAMIC_STRINGS_SERVICE;

public class DynamicStringsTextView extends AppCompatTextView {

    private static final String TAG = DynamicStringsTextView.class.getSimpleName();

    private final DynamicStringsTextViewDelegate delegate;

    public DynamicStringsTextView(Context context) {
        this(context, null);
    }

    public DynamicStringsTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DynamicStringsTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //noinspection WrongConstant
        DynamicStrings dynamicStrings = (DynamicStrings) context.getSystemService(DYNAMIC_STRINGS_SERVICE);

        if (dynamicStrings == null) {
            Log.w(TAG, "DynamicStrings not found. Have you overridden getSystemService()");
        }

        delegate = new DynamicStringsTextViewDelegate(dynamicStrings, this, attrs);
    }
}
