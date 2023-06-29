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

        System.out.println();

        System.out.println("Welcome to Currency Calculator! Feel free to make as much calculations as you want!");
        System.out.println("(If you want to leave Currency Calculator type 'EXIT')");

        System.out.println();

        boolean running = true;
        while (running) {
            System.out.println("Enter the source currency:");
            String sourceCurrencyName = scanner.nextLine().toUpperCase();

            if (sourceCurrencyName.equals("EXIT")) {
                running = false;
                break;
            }

            if (!Currency.contains(sourceCurrencyName)) {
                System.out.println("Invalid source currency. Please enter a valid currency");
                continue;
            }

            System.out.println("Enter the target currency:");
            String targetCurrencyName = scanner.nextLine().toUpperCase();

            if (!Currency.contains(targetCurrencyName)) {
                System.out.println("Invalid target currency. Please enter a valid currency");
                continue;
            }

            System.out.println("Enter the quantity");
            double currencyAmount;
            try {
                currencyAmount = Double.parseDouble(scanner.nextLine());
                if (currencyAmount <= 0) {
                    System.out.println("Invalid amount. Please enter a positive number");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number");
                continue;
            }

            double amount = calculator.calculate(currencyAmount, sourceCurrencyName, targetCurrencyName);
            System.out.println("Calculated value: " + amount + " " + targetCurrencyName);
        }

        System.out.println("Exiting the program. Goodbye!");
    }
}
