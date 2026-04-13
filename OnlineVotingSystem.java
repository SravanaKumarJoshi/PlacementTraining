import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] candidates = {"Alice", "Bob", "Charlie"};
        int[] votes = new int[3];
        boolean hasVoted = false;

        System.out.println("Candidates:");
        for (int i = 0; i < candidates.length; i++) {
            System.out.println((i + 1) + ". " + candidates[i]);
        }

        if (!hasVoted) {
            System.out.print("Enter your vote (1-3): ");
            int choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {
                votes[choice - 1]++;
                hasVoted = true;
                System.out.println("Vote casted!");
            } else {
                System.out.println("Invalid choice");
            }
        }

        System.out.println("\n--- Results ---");
        for (int i = 0; i < votes.length; i++) {
            System.out.println(candidates[i] + ": " + votes[i]);
        }
    }
}
