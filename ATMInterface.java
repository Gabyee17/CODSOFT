import java.util.Scanner;

public class ATMInterface {

    // Inner class to represent the user's bank account
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("₹" + amount + " deposited successfully.");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("₹" + amount + " withdrawn successfully.");
                return true;
            } else {
                System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(5000.0); // ₹5000 starting balance

        int choice;

        // Step 2: ATM Menu
        do {
            System.out.println("\n====== ATM MENU ======");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Check balance
                    System.out.println("Current Balance: ₹" + userAccount.getBalance());
                    break;
                case 2:
                    // Deposit
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    // Withdraw
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
