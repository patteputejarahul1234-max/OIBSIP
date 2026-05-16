import java.util.ArrayList;
public class BankAccount {
    private double balance;
    private ArrayList<String> transactionHistory;
    public BankAccount(double initialBalance) {
        balance = initialBalance;
        transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: ₹" + initialBalance);
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nTransaction Successful");
            System.out.println("Deposited Amount: ₹" + amount);
            System.out.println("Available Balance: ₹" + balance);
            transactionHistory.add("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\nTransaction Successful");
            System.out.println("Withdrawn Amount: ₹" + amount);
            System.out.println("Available Balance: ₹" + balance);
            transactionHistory.add("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
    public double getBalance() {
        return balance;
    }
    public void showTransactionHistory() {
        System.out.println("\n========== TRANSACTION HISTORY ==========");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}