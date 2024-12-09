import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        // Create a sample account (userId, pin, balance)
        Account account = new Account("user1", "1234", 5000);
        ATMFunctions atmFunctions = new ATMFunctions(account);

        Scanner scanner = new Scanner(System.in);

        // User authentication
        String enteredUserId = InputValidator.getValidUserId();
        String enteredPin = InputValidator.getValidPin();

        if (enteredUserId.equals(account.getUserId()) && enteredPin.equals(account.getPin())) {
            System.out.println("Authentication successful!");

            boolean quit = false;
            while (!quit) {
                // Menu options
                System.out.println("\nATM Menu:");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                System.out.print("Enter option: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // consume newline

                switch (option) {
                    case 1:
                        atmFunctions.viewTransactionHistory();
                        break;
                    case 2:
                        double withdrawAmount = InputValidator.getValidAmount();
                        atmFunctions.withdraw(withdrawAmount);
                        break;
                    case 3:
                        double depositAmount = InputValidator.getValidAmount();
                        atmFunctions.deposit(depositAmount);
                        break;
                    case 4:
                        double transferAmount = InputValidator.getValidAmount();
                        // Assuming the transfer is to the same account for simplicity
                        atmFunctions.transfer(account, transferAmount);
                        break;
                    case 5:
                        quit = true;
                        System.out.println("Exiting the ATM system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Authentication failed! Invalid User ID or PIN.");
        }

        scanner.close();
    }
}
