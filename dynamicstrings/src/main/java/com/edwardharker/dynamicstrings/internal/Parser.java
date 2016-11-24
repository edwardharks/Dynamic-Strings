package com.edwardharker.dynamicstrings.internal;

import java.io.InputStream;

public interface Parser {

    StringResources parseStrings(InputStream stringsXml);
}
