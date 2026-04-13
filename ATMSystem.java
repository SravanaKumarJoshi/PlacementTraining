import java.util.*;

public class ATMSystem {

    // Account structure using arrays
    static int[] accountNumbers = {1001, 1002, 1003};
    static int[] pins = {1111, 2222, 3333};
    static double[] balances = {5000.0, 7000.0, 10000.0};

    // Transaction history
    static String[] history = new String[100];
    static int historyCount = 0;

    // Add transaction
    public static void addHistory(String record) {
        history[historyCount++] = record;
    }

    // Find account index
    public static int findAccount(int accNo) {
        for (int i = 0; i < accountNumbers.length; i++) {
            if (accountNumbers[i] == accNo) {
                return i;
            }
        }
        return -1;
    }

    // Deposit
    public static void deposit(int index, double amount) {
        balances[index] += amount;
        addHistory("Deposited: " + amount);
        System.out.println("Amount deposited successfully!");
    }

    // Withdraw
    public static void withdraw(int index, double amount) {
        if (amount <= balances[index]) {
            balances[index] -= amount;
            addHistory("Withdrawn: " + amount);
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Transfer
    public static void transfer(int fromIndex, int toAcc, double amount) {
        int toIndex = findAccount(toAcc);

        if (toIndex == -1) {
            System.out.println("Receiver account not found!");
            return;
        }

        if (amount <= balances[fromIndex]) {
            balances[fromIndex] -= amount;
            balances[toIndex] += amount;
            addHistory("Transferred " + amount + " to Acc " + toAcc);
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Show history
    public static void showHistory() {
        System.out.println("\n--- Transaction History ---");
        for (int i = 0; i < historyCount; i++) {
            System.out.println(history[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        int index = findAccount(accNo);

        if (index == -1) {
            System.out.println("Account not found!");
            return;
        }

        // PIN attempts
        int attempts = 3;
        boolean authenticated = false;

        while (attempts > 0) {
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == pins[index]) {
                authenticated = true;
                break;
            } else {
                attempts--;
                System.out.println("Wrong PIN! Attempts left: " + attempts);
            }
        }

        if (!authenticated) {
            System.out.println("Card blocked!");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + balances[index]);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    deposit(index, dep);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double wit = sc.nextDouble();
                    withdraw(index, wit);
                    break;

                case 4:
                    System.out.print("Enter receiver account: ");
                    int toAcc = sc.nextInt();
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    transfer(index, toAcc, amt);
                    break;

                case 5:
                    showHistory();
                    break;

                case 6:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
