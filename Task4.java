import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");

        while (true) {
            System.out.println("Select the base currency:");
            System.out.println("1. USD (United States Dollar)");
            System.out.println("2. EUR (Euro)");
            // Add more currencies as needed

            int baseCurrencyChoice = getChoice(scanner);

            String baseCurrency = getCurrencyCode(baseCurrencyChoice);

            System.out.println("Select the target currency:");
            System.out.println("1. USD (United States Dollar)");
            System.out.println("2. EUR (Euro)");
            // Add more currencies as needed

            int targetCurrencyChoice = getChoice(scanner);

            String targetCurrency = getCurrencyCode(targetCurrencyChoice);

            double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);

            if (exchangeRate == -1) {
                System.out.println("Failed to fetch exchange rate. Please try again later.");
                continue;
            }

            double amount = getAmount(scanner);

            double convertedAmount = amount * exchangeRate;

            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);

            System.out.print("Do you want to convert another amount? (yes/no): ");
            String response = scanner.next().toLowerCase();

            if (!response.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for using Currency Converter!");
        scanner.close();
    }

    private static int getChoice(Scanner scanner) {
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 2) { // Adjust the range based on the number of currencies available
                    break;
                }
            } else {
                scanner.next(); // Consume invalid input
            }
            System.out.println("Invalid choice. Please select a valid option.");
        }
        return choice;
    }

    private static String getCurrencyCode(int choice) {
        switch (choice) {
            case 1:
                return "USD";
            case 2:
                return "EUR";
            // Add more cases for other currencies
            default:
                return null;
        }
    }

    private static double fetchExchangeRate(String baseCurrency, String targetCurrency) {
        // Integrate code to fetch exchange rate from API
        // Replace the following line with API call to get the exchange rate
        return 0.85; // Dummy exchange rate, replace it with actual fetched rate
    }

    private static double getAmount(Scanner scanner) {
        double amount;
        while (true) {
            System.out.print("Enter the amount to convert: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount >= 0) {
                    break;
                }
            } else {
                scanner.next(); // Consume invalid input
            }
            System.out.println("Invalid amount. Please enter a non-negative number.");
        }
        return amount;
    }
}
