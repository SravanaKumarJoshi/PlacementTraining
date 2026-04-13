import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "Capital of India?",
            "2 + 2 = ?"
        };

        String[][] options = {
            {"Delhi", "Mumbai", "Chennai"},
            {"3", "4", "5"}
        };

        int[] answers = {1, 2}; // correct options

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n" + questions[i]);

            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }

            System.out.print("Enter answer: ");
            int ans = sc.nextInt();

            if (ans == answers[i]) {
                score++;
            }
        }

        System.out.println("Your Score: " + score);
    }
}
