import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Double> currencyMap = CurrencyParser.parse();
        Calculator calculator = new Calculator(currencyMap);

        System.out.println("For which currency would you like to count?");
        String currencyName = scanner.nextLine().toUpperCase();
        System.out.println("Enter the quantity");
        Double currencyAmount = Double.valueOf(scanner.nextLine());

        double amount = calculator.calculate(currencyAmount, currencyName);
        System.out.println("Calculated value: " + amount + " " + currencyName);
    }
}
