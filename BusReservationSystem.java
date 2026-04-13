import java.util.*;

public class BusReservation {
    static int[][] seats = new int[5][4]; // 5 rows, 4 columns
    static Scanner sc = new Scanner(System.in);

    public static void showSeats() {
        System.out.println("\n--- Seat Layout ---");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bookSeat() {
        System.out.print("Enter row (1-5): ");
        int r = sc.nextInt() - 1;

        System.out.print("Enter seat (1-4): ");
        int c = sc.nextInt() - 1;

        if (seats[r][c] == 0) {
            seats[r][c] = 1;
            System.out.println("Seat booked!");
        } else {
            System.out.println("Already booked!");
        }
    }

    public static void cancelSeat() {
        System.out.print("Enter row: ");
        int r = sc.nextInt() - 1;

        System.out.print("Enter seat: ");
        int c = sc.nextInt() - 1;

        if (seats[r][c] == 1) {
            seats[r][c] = 0;
            System.out.println("Booking cancelled!");
        } else {
            System.out.println("Seat already empty!");
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1. View Seats\n2. Book\n3. Cancel\n4. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1: showSeats(); break;
                case 2: bookSeat(); break;
                case 3: cancelSeat(); break;
            }
        } while (choice != 4);
    }
}
