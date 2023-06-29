import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Calculator {

    private final Map<String, Double> currencyMap;

    public Calculator(Map<String, Double> currencyMap) {
        this.currencyMap = currencyMap;
    }

    public double calculate (double amountEuro, String currencyName) {
        String currency = getCurrency(currencyName);
        Double rate = currencyMap.get(currency);

        if (rate == null) {
            System.out.println("Currency not found " + currencyName);
            return 0.0;
        }

        BigDecimal rateBigDecimal = BigDecimal.valueOf(rate);
        BigDecimal amount = rateBigDecimal.multiply(BigDecimal.valueOf(amountEuro));
        amount = amount.setScale(2, RoundingMode.HALF_UP);
        return amount.doubleValue();
    }

    private String getCurrency(String currencyName) {
        return currencyMap.keySet()
                .stream()
                .filter(currency -> currency.equals(currencyName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Currency " + currencyName + " do not exist."));
    }
}
