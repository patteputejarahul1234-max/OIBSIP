import java.util.Scanner;
public class ATM {
    private BankAccount account;
    private Scanner scanner;
    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }
    public void start() {
        int attempts = 3;
        int correctPin = 1234;
        System.out.println("=================================");
        System.out.println("        ATM INTERFACE");
        System.out.println("=================================");
        while (attempts > 0) {
            System.out.print("Enter ATM PIN: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid PIN format.");
                scanner.next();
                continue;
            }
            int enteredPin = scanner.nextInt();
            if (enteredPin == correctPin) {
                System.out.println("\nLogin Successful!");
                menu();
                return;
            } else {
                attempts--;
                System.out.println("Incorrect PIN.");
                System.out.println("Remaining Attempts: " + attempts);
            }
        }
        System.out.println("\nToo many incorrect attempts.");
        System.out.println("ATM Access Blocked.");
    }
    private void menu() {
        int choice = 0;
        do {
            System.out.println("\n==============================");
            System.out.println("           ATM MENU");
            System.out.println("==============================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter numbers only.");
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("\nThank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
    private void checkBalance() {
        System.out.println("\nCurrent Balance: ₹" + account.getBalance());
    }
    private void depositMoney() {
        System.out.print("\nEnter amount to deposit: ₹");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }
    private void withdrawMoney() {
        System.out.print("\nEnter amount to withdraw: ₹");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}