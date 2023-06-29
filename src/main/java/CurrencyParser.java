import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class CurrencyParser {

    private static final String FILE = "currency.xml";
    private static final DocumentBuilder DOCUMENT_BUILDER;

    static {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DOCUMENT_BUILDER = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("Error creating document builder: " + e.getMessage());
        }
    }

    public static Map<String, Double> parse() {
        Map<String, Double> currencies = new HashMap<>();

        try {
            InputStream inputStream = CurrencyParser.class.getClassLoader().getResourceAsStream(FILE);
            Document document = DOCUMENT_BUILDER.parse(inputStream);
            NodeList nodeList = document.getElementsByTagName("Cube");

            for (int i = 0; i < nodeList.getLength(); i++) {
                NamedNodeMap attributes = nodeList.item(i).getAttributes();
                Node currencyName = attributes.getNamedItem("currency");
                Node currencyRate = attributes.getNamedItem("rate");

                if (currencyName != null && currencyRate != null) {
                    String name = currencyName.getTextContent();
                    String rateValue = currencyRate.getTextContent();

                    try {
                        double rate = Double.parseDouble(rateValue);
                        currencies.put(name, rate);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid rate value for currency: " + name);
                    }
                } else {
                    System.err.println("Incomplete currency data at index: " + i);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println("Error parsing XML: " + e.getMessage());
        }

        return currencies;
    }
}
