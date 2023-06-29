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
import java.util.HashMap;
import java.util.Map;

public class CurrencyParser {

    private static final String FILE = "currency.xml";

    public static Map<String, Double> parse() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        Map<String, Double> currencies = new HashMap<>();

        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(FILE));
            NodeList nodeList = document.getElementsByTagName("Cube");
            for (int i = 0; i < nodeList.getLength(); i++) {
                NamedNodeMap attributes = nodeList.item(i).getAttributes();
                Node currencyName = attributes.getNamedItem("currency");
                Node currencyRate = attributes.getNamedItem("rate");
                if (currencyName != null) {
                    currencies.put(currencyName.getTextContent(), Double.valueOf(currencyRate.getTextContent()));
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        return currencies;
    }
}
