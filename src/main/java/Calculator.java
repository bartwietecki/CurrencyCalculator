import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Calculator {

    private final Map<String, Double> currencyMap;

    public Calculator(Map<String, Double> currencyMap) {
        this.currencyMap = currencyMap;
    }

    public double calculate (double amount, String sourceCurrency, String targetCurrency ) {
        Double sourceRate = currencyMap.get(sourceCurrency);
        Double targetRate = currencyMap.get(targetCurrency);

        if (sourceRate == null || targetRate == null) {
            System.out.println("Currency not found.");
            return 0.0;
        }

        BigDecimal sourceRateBigDecimal = BigDecimal.valueOf(sourceRate);
        BigDecimal targetRateBigDecimal = BigDecimal.valueOf(targetRate);
        BigDecimal amountBigDecimal = BigDecimal.valueOf(amount);

        BigDecimal convertedAmount = amountBigDecimal.multiply(targetRateBigDecimal).divide(sourceRateBigDecimal, 2, RoundingMode.HALF_UP);
        return convertedAmount.doubleValue();

    }
}
