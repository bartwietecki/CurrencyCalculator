import java.util.Map;

public class Calculator {

    private final Map<String, Double> currencyMap;

    public Calculator(Map<String, Double> currencyMap) {
        this.currencyMap = currencyMap;
    }

    public double calculate (double amountEuro, String currencyName) {
        String currency = getCurrency(currencyName);
        Double rate = currencyMap.get(currency);
        double amount = rate * amountEuro;
        return getRoundedValue(amount);
    }

    private double getRoundedValue(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }

    private String getCurrency(String currencyName) {
        return currencyMap.keySet()
                .stream()
                .filter(currency -> currency.equals(currencyName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Currency " + currencyName + " do not exist."));
    }
}
