import java.util.*;

public class LibraryManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static int maxBooks = 10;

    static int[] bookId = new int[maxBooks];
    static String[] bookName = new String[maxBooks];
    static boolean[] isIssued = new boolean[maxBooks];

    static int count = 0;

    // Add Book
    public static void addBook() {
        if (count >= maxBooks) {
            System.out.println("Library is full!");
            return;
        }

        System.out.print("Enter Book ID: ");
        bookId[count] = sc.nextInt();

        sc.nextLine(); // clear buffer
        System.out.print("Enter Book Name: ");
        bookName[count] = sc.nextLine();

        isIssued[count] = false;
        count++;

        System.out.println("Book added successfully!");
    }

    // View Books
    public static void viewBooks() {
        if (count == 0) {
            System.out.println("No books available!");
            return;
        }

        System.out.println("\n--- Book List ---");
        for (int i = 0; i < count; i++) {
            System.out.println(
                "ID: " + bookId[i] +
                " | Name: " + bookName[i] +
                " | Status: " + (isIssued[i] ? "Issued" : "Available")
            );
        }
    }

    // Search Book
    public static int searchBook(int id) {
        for (int i = 0; i < count; i++) {
            if (bookId[i] == id) {
                return i;
            }
        }
        return -1;
    }

    // Issue Book
    public static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        int index = searchBook(id);

        if (index == -1) {
            System.out.println("Book not found!");
        } else if (isIssued[index]) {
            System.out.println("Book already issued!");
        } else {
            isIssued[index] = true;
            System.out.println("Book issued successfully!");
        }
    }

    // Return Book
    public static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        int index = searchBook(id);

        if (index == -1) {
            System.out.println("Book not found!");
        } else if (!isIssued[index]) {
            System.out.println("Book was not issued!");
        } else {
            isIssued[index] = false;
            System.out.println("Book returned successfully!");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    issueBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}LibraryManagementSystem.java
