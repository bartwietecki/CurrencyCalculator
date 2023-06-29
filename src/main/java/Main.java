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

        boolean running = true;
        while (running) {
            System.out.println("What currency would you like to change your Euro funds to?");
            String currencyName = scanner.nextLine().toUpperCase();

            if (currencyName.equals("EXIT")) {
                running = false;
                break;
            }

            if (!currencyMap.containsKey(currencyName)) {
                System.out.println("Invalid currency. Please enter a valid currency");
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

            double amount = calculator.calculate(currencyAmount, currencyName);
            System.out.println("Calculated value: " + amount + " " + currencyName);
        }

        System.out.println("Exiting the program. Goodbye!");
    }
}
