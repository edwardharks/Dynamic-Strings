package com.edwardharker.dynamicstrings;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.edwardharker.dynamicstrings.internal.StringResources;


final class DynamicStringsResources extends Resources {

    private final DynamicStrings dynamicStrings;

    DynamicStringsResources(Resources from, DynamicStrings dynamicStrings) {
        //noinspection deprecation
        super(from.getAssets(), from.getDisplayMetrics(), from.getConfiguration());
        this.dynamicStrings = dynamicStrings;
    }

    @NonNull
    @Override
    public String getString(int id) throws NotFoundException {
        CharSequence result = getTextInternal(id);
        if (result != null) {
            return result.toString();
        }
        return super.getString(id);
    }

    @NonNull
    @Override
    public String getString(int id, Object... formatArgs) throws NotFoundException {
        String raw = getString(id);
        //noinspection deprecation
        return String.format(getConfiguration().locale, raw, formatArgs);
    }

    @NonNull
    @Override
    public CharSequence getText(int id) throws NotFoundException {
        CharSequence result = getTextInternal(id);
        if (result != null) {
            return result;
        }
        return super.getText(id);
    }

    @Override
    public CharSequence getText(int id, CharSequence def) {
        CharSequence result = getTextInternal(id);
        if (result != null) {
            return result;
        }
        return super.getText(id, def);
    }

    @Nullable
    private CharSequence getTextInternal(int id) {
        StringResources stringResources = dynamicStrings.getStringResources();
        return stringResources.getText(getResourceEntryName(id));
    }
}
