import java.util.Scanner;

public class InputValidator {
    private static Scanner scanner = new Scanner(System.in);

    public static String getValidUserId() {
        System.out.print("Enter User ID: ");
        return scanner.nextLine();
    }

    public static String getValidPin() {
        System.out.print("Enter PIN: ");
        return scanner.nextLine();
    }

    public static double getValidAmount() {
        double amount = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter amount: ");
                amount = Double.parseDouble(scanner.nextLine());
                if (amount > 0) {
                    valid = true;
                } else {
                    System.out.println("Amount must be greater than zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        return amount;
    }
}

