import java.util.Scanner;

public class BankingAccount {
    private double balance;

    public BankingAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void checkBalance() {
        System.out.printf("Current balance: RM \n", balance);
    }

    public void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: RM ");
        double amount = scanner.nextDouble();
        if (amount < 0) {
            System.out.println("Cannot deposit a negative amount.");
        } else {
            balance += amount;
            System.out.printf("Deposited RM , new balance: RM \n", amount, balance);
        }

    }

    public void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: RM ");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else if (amount < 0) {
            System.out.println("Cannot withdraw a negative amount.");
        } else {
            balance -= amount;
            System.out.printf("Withdrew RM , remaining balance: RM \n", amount, balance);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingAccount account = new BankingAccount(0.0); // Starting balance can be set here

        while (true) {
            System.out.println("\n Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    account.depositMoney();
                    break;
                case 3:
                    account.withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for your visit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
