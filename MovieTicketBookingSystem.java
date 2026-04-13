import java.util.*;

public class MovieBooking {
    static int[][] seats = new int[5][5];
    static int price = 150;
    static Scanner sc = new Scanner(System.in);

    public static void showSeats() {
        System.out.println("\n--- Seats ---");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bookSeat() {
        System.out.print("Enter row: ");
        int r = sc.nextInt() - 1;

        System.out.print("Enter column: ");
        int c = sc.nextInt() - 1;

        if (seats[r][c] == 0) {
            seats[r][c] = 1;
            System.out.println("Booked! Price: ₹" + price);
        } else {
            System.out.println("Already booked!");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. View Seats\n2. Book\n3. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1: showSeats(); break;
                case 2: bookSeat(); break;
            }
        } while (choice != 3);
    }
}
