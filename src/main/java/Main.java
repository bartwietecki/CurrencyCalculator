import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Double> currencyMap = CurrencyParser.parse();
        Calculator calculator = new Calculator(currencyMap);

        System.out.println("Available currencies");
        for (Currency currency : Currency.values()) {
            System.out.println(currency.name() + " - " + currency.getFullName());
        }

        System.out.println("What currency would you like to change your Euro funds to?");
        String currencyName = scanner.nextLine().toUpperCase();
        System.out.println("Enter the quantity");
        Double currencyAmount = Double.valueOf(scanner.nextLine());

        double amount = calculator.calculate(currencyAmount, currencyName);
        System.out.println("Calculated value: " + amount + " " + currencyName);
    }
}
