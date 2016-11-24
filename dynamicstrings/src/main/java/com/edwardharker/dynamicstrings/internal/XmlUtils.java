package com.edwardharker.dynamicstrings.internal;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

final class XmlUtils {

    private XmlUtils() {
    }

    static Document readXml(InputStream inputStream) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.parse(inputStream);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new ParserException("Failed to read xml document from input stream", e);
        }
    }
}
