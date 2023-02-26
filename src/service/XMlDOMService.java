package service;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMlDOMService {
    private final List<Object> tree = new ArrayList<>();
    public Document parse(String uri) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return builder.parse(uri);
    }
    public List<Object> readTreeFromElement(NodeList list){
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);

            if (node.getNodeType() == Node.TEXT_NODE) {
                String textInformation = node.getNodeValue().replace("\n", "").trim();

                if (!textInformation.isEmpty())
                    tree.add("Element has text: " + node.getNodeValue());

            } else {
                tree.add("Element: " + node.getNodeName() + ". It's parent element: " + node.getParentNode().getNodeName());
                NamedNodeMap attributes = node.getAttributes();

                for (int j = 0; j < attributes.getLength(); j++) {
                    tree.add(node.getNodeName() + "'s attribute is " + attributes.item(j).getNodeName() + ". It's value: " + attributes.item(j).getNodeValue());
                }
                if (node.hasChildNodes()) {
                    readTreeFromElement(node.getChildNodes());
                }
            }
        }
        return tree;
    }
}
