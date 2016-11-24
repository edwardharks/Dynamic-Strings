package com.edwardharker.dynamicstrings.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class StringResources {

    public static final StringResources EMPTY = new StringResources(Collections.<String, CharSequence>emptyMap());

    private final HashMap<String, CharSequence> strings;

    StringResources(Map<String, CharSequence> strings) {
        this.strings = new HashMap<>(strings);
    }

    public CharSequence getText(String key) {
        return strings.get(key);
    }

    public boolean has(String key) {
        return strings.containsKey(key);
    }
}
