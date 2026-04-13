import java.util.*;

public class HospitalSystem {

    static String[] patientName = new String[10];
    static String[] disease = new String[10];
    static int[] days = new int[10];
    static int count = 0;
    static int chargePerDay = 500;

    static Scanner sc = new Scanner(System.in);

    public static void addPatient() {
        System.out.print("Enter name: ");
        patientName[count] = sc.next();

        System.out.print("Enter disease: ");
        disease[count] = sc.next();

        System.out.print("Enter days admitted: ");
        days[count] = sc.nextInt();

        count++;
        System.out.println("Patient added!");
    }

    public static void showPatients() {
        for (int i = 0; i < count; i++) {
            System.out.println(patientName[i] + " - " + disease[i]);
        }
    }

    public static void bill() {
        System.out.print("Enter patient index: ");
        int i = sc.nextInt();

        int total = days[i] * chargePerDay;
        System.out.println("Total Bill: ₹" + total);
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add\n2. View\n3. Bill\n4. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addPatient(); break;
                case 2: showPatients(); break;
                case 3: bill(); break;
            }
        } while (choice != 4);
    }
}
