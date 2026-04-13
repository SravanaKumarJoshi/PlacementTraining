import java.util.*;

public class HotelManagementSystem {

    static Scanner sc = new Scanner(System.in);

    // Room data
    static int totalRooms = 5;
    static boolean[] isBooked = new boolean[totalRooms];
    static String[] customerName = new String[totalRooms];
    static int[] daysStayed = new int[totalRooms];

    static int pricePerDay = 1000;

    // Show available rooms
    public static void showRooms() {
        System.out.println("\n--- Room Status ---");
        for (int i = 0; i < totalRooms; i++) {
            if (!isBooked[i]) {
                System.out.println("Room " + (i + 1) + " is Available");
            } else {
                System.out.println("Room " + (i + 1) + " is Booked by " + customerName[i]);
            }
        }
    }

    // Book room
    public static void bookRoom() {
        showRooms();
        System.out.print("Enter room number to book: ");
        int room = sc.nextInt() - 1;

        if (room >= 0 && room < totalRooms && !isBooked[room]) {
            sc.nextLine(); // clear buffer
            System.out.print("Enter customer name: ");
            customerName[room] = sc.nextLine();

            System.out.print("Enter number of days: ");
            daysStayed[room] = sc.nextInt();

            isBooked[room] = true;

            System.out.println("Room booked successfully!");
        } else {
            System.out.println("Invalid or already booked room!");
        }
    }

    // Checkout
    public static void checkout() {
        System.out.print("Enter room number to checkout: ");
        int room = sc.nextInt() - 1;

        if (room >= 0 && room < totalRooms && isBooked[room]) {
            int bill = daysStayed[room] * pricePerDay;

            System.out.println("\n--- Bill Details ---");
            System.out.println("Customer: " + customerName[room]);
            System.out.println("Days Stayed: " + daysStayed[room]);
            System.out.println("Total Bill: ₹" + bill);

            // Reset room
            isBooked[room] = false;
            customerName[room] = null;
            daysStayed[room] = 0;

            System.out.println("Checkout successful!");
        } else {
            System.out.println("Invalid room or already empty!");
        }
    }

    // Main menu
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOTEL MANAGEMENT SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    checkout();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}
