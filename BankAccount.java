import java.util.Scanner;

class Bank {
    int accountNumber;
    double balance;

    public Bank(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void displayCheckaBalance() {
        System.out.printf("The current balance is: RM %.2f\n", balance);
    }

    public void depositMoney(double amount) {
        balance += amount;
    }

    public void WithdrawMoney(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("Withdrawal successful! New balance: RM %.2f\n", balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public static class BankAccount {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Bank account = new Bank(138654298, 12000);

            int choice;
            do {
                System.out.println("Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        account.displayCheckaBalance();
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.depositMoney(depositAmount);
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.WithdrawMoney(withdrawAmount);
                        break;

                    case 4:
                        System.out.println("Thank you for your visit");
                        break;

                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }
            } while (choice != 4);

            scanner.close();
        }
    }
}
