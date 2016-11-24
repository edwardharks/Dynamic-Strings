package com.edwardharker.dynamicstrings.internal;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.HashMap;

import static android.text.TextUtils.isEmpty;
import static com.edwardharker.dynamicstrings.internal.XmlUtils.readXml;

public final class XmlParser implements Parser {

    @Override
    public StringResources parseStrings(InputStream stringsXml) {
        Document document = readXml(stringsXml);
        Node resourcesNode = document.getElementsByTagName("resources").item(0);
        NodeList resourcesNodes = resourcesNode.getChildNodes();

        HashMap<String, CharSequence> strings = new HashMap<>();

        for (int i = 0; i < resourcesNodes.getLength(); i++) {
            Node item = resourcesNodes.item(i);
            String stringValue = item.getTextContent();
            String stringName = null;
            NamedNodeMap attributes = item.getAttributes();
            if (attributes != null) {
                for (int j = 0; j < attributes.getLength(); j++) {
                    Node attribute = attributes.item(j);
                    stringName = attribute.getNodeValue();
                }
            }

            if (!isEmpty(stringName) && !isEmpty(stringValue)) {
                strings.put(stringName, stringValue);
            }
        }

        return new StringResources(strings);
    }
}
