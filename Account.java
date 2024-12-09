import java.util.ArrayList;
import java.util.List;

public class Account {
    private String userId;
    private String pin;
    private double balance;
    private List<Transaction> transactions;

    public Account(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Add transaction
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}

