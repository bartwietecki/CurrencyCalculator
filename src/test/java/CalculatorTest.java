import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private Map<String, Double> currencyMap;

    @BeforeEach
    public void setUp() {
        currencyMap = new HashMap<>();
        currencyMap.put("USD", 1.12);
        currencyMap.put("GBP", 0.88);
        currencyMap.put("JPY", 123.45);

        calculator = new Calculator(currencyMap);
    }

    @Test
    public void testCalculateConversion() {
        double amount = 100.0;
        String invalidCurrency = "XXX";
        String targetCurrency = "GBP";

        double convertedAmount = calculator.calculate(amount, invalidCurrency, targetCurrency);

        // Checking if it returns 0.0 for non-existing currency
        Assertions.assertEquals(0.0, convertedAmount, 0.001);
    }

}