import java.util.*;

public class ExpenseTracker {

    static double[] expenses = new double[20];
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void addExpense() {
        System.out.print("Enter expense: ");
        expenses[count++] = sc.nextDouble();
    }

    public static void showTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += expenses[i];
        }
        System.out.println("Total Expense: ₹" + total);
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add Expense\n2. View Total\n3. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addExpense(); break;
                case 2: showTotal(); break;
            }
        } while (choice != 3);
    }
}
