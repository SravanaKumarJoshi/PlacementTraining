import java.util.*;

public class PasswordManager {

    static String[] websites = new String[10];
    static String[] passwords = new String[10];
    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    // Simple encryption
    public static String encrypt(String pass) {
        String result = "";
        for (char c : pass.toCharArray()) {
            result += (char)(c + 2);
        }
        return result;
    }

    public static void addPassword() {
        System.out.print("Enter website: ");
        websites[count] = sc.next();

        System.out.print("Enter password: ");
        String pass = sc.next();

        passwords[count] = encrypt(pass);
        count++;

        System.out.println("Saved securely!");
    }

    public static void viewPasswords() {
        for (int i = 0; i < count; i++) {
            System.out.println(websites[i] + " -> " + passwords[i]);
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add\n2. View\n3. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addPassword(); break;
                case 2: viewPasswords(); break;
            }
        } while (choice != 3);
    }
}
