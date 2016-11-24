package com.edwardharker.demo;

import android.os.Bundle;
import android.widget.TextView;

import com.edwardharker.dynamicstrings.DynamicStringsActivity;

public class MainActivity extends DynamicStringsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.set_text_id)).setText(R.string.set_text_id);
        ((TextView) findViewById(R.id.set_text_get_string)).setText(getString(R.string.set_text_get_string));
        ((TextView) findViewById(R.id.set_text_get_string_formatted))
                .setText(getString(R.string.set_text_get_string_formatted, "formatArgs"));
    }
}
