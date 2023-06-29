import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyParserTest {

    @Test
    public void testCurrencyParsing() {
        Map<String, Double> currencyMap = CurrencyParser.parse();

        // Checking if currencyMap contains keys and values
        Assertions.assertTrue(currencyMap.containsKey("USD"));
        Assertions.assertTrue(currencyMap.containsKey("GBP"));
        Assertions.assertTrue(currencyMap.containsKey("JPY"));

        Assertions.assertEquals(1.2198, currencyMap.get("USD"), 0.001);
        Assertions.assertEquals(0.86068, currencyMap.get("GBP"), 0.001);
        Assertions.assertEquals(133.42, currencyMap.get("JPY"), 0.001);
    }

}