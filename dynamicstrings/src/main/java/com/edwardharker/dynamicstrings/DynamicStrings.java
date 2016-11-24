package com.edwardharker.dynamicstrings;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;

import com.edwardharker.dynamicstrings.internal.Parser;
import com.edwardharker.dynamicstrings.internal.StringResources;
import com.edwardharker.dynamicstrings.internal.XmlParser;

import java.io.InputStream;


public final class DynamicStrings {

    public static final String DYNAMIC_STRINGS_SERVICE = "DYNAMIC_STRINGS_SERVICE";

    private final Parser parser;
    private final DynamicStringsViewCreator viewCreator;

    private StringResources stringResources = StringResources.EMPTY;

    public DynamicStrings() {
        this(new XmlParser(), new DynamicStringsViewCreator());
    }

    private DynamicStrings(Parser parser, DynamicStringsViewCreator viewCreator) {
        this.parser = parser;
        this.viewCreator = viewCreator;
    }

    /**
     * Set the strings xml file to be used by this DynamicStrings
     *
     * @param stringsXml the strings xml to use
     */
    public void loadStrings(InputStream stringsXml) {
        stringResources = parser.parseStrings(stringsXml);
    }

    /**
     * Wrap the context so that it is aware of dynamic strings
     *
     * @param context the context to wrap
     * @return a context that will return dynamically loaded strings for calls to getString()
     */
    @NonNull
    public Context wrap(@NonNull Context context) {
        if (context instanceof DynamicStringsContextWrapper) {
            return context;
        }
        return DynamicStringsContextWrapper.wrap(context, this);
    }

    /**
     * Get a LayoutInflaterFactory that is able to create DynamicStrings aware views
     *
     * @param appCompatDelegate the app compat delegate of the Activity
     * @return A DynamicStrings aware LayoutInflaterFactory
     */
    @NonNull
    public LayoutInflaterFactory layoutInflaterFactory(@NonNull AppCompatDelegate appCompatDelegate) {
        return new DynamicStringsLayoutInflaterFactory(appCompatDelegate, this);
    }

    /**
     * Call from getSystemService(name) to check if this DynamicStrings should be returned
     *
     * @param name the name passed into getSystemService(name)
     * @return true if getSystemService(name) should return this DynamicStrings
     */
    public boolean isSystemService(String name) {
        return name.equals(DYNAMIC_STRINGS_SERVICE);
    }

    /**
     * Call from LayoutInflaterFactory.createView() to create DynamicStrings aware views
     *
     * @return a DynamicStrings aware view or null
     */
    @Nullable
    public View createView(String name, Context context, AttributeSet attrs) {
        return viewCreator.createView(name, context, attrs);
    }

    StringResources getStringResources() {
        return stringResources;
    }
}
