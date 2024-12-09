public class ATMFunctions {
    private Account account;

    public ATMFunctions(Account account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            account.addTransaction(new Transaction("Withdraw", amount));
            System.out.println("Withdrawal successful! New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        account.addTransaction(new Transaction("Deposit", amount));
        System.out.println("Deposit successful! New balance: " + account.getBalance());
    }

    public void transfer(Account toAccount, double amount) {
        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            account.addTransaction(new Transaction("Transfer", amount));
            System.out.println("Transfer successful! New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
    }
}
