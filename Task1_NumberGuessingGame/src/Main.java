import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int round = 1;
        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");
        while (playAgain) {
            System.out.println("\n========== ROUND " + round + " ==========");
            int maxNumber = 0;
            int maxAttempts = 0;
            while (true) {
                System.out.println("\nSelect Difficulty Level:");
                System.out.println("1. Easy   (1 to 50)");
                System.out.println("2. Medium (1 to 100)");
                System.out.println("3. Hard   (1 to 200)");
                System.out.print("Enter your choice: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter numbers only.");
                    scanner.next();
                    continue;
                }
                int difficultyChoice = scanner.nextInt();
                if (difficultyChoice == 1) {
                    maxNumber = 50;
                    maxAttempts = 10;
                    break;
                } else if (difficultyChoice == 2) {
                    maxNumber = 100;
                    maxAttempts = 7;
                    break;
                } else if (difficultyChoice == 3) {
                    maxNumber = 200;
                    maxAttempts = 5;
                    break;
                } else {
                    System.out.println("Please select 1, 2, or 3 only.");
                }
            }
            int randomNumber = random.nextInt(maxNumber) + 1;
            int userGuess = 0;
            int attempts = 0;
            System.out.println("\nGuess a number between 1 and " + maxNumber);
            while (userGuess != randomNumber && attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + " of " + maxAttempts + " - Enter your guess: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next();
                    continue;
                }
                userGuess = scanner.nextInt();
                attempts++;
                if (userGuess > randomNumber) {
                    System.out.println("Too High!");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too Low!");
                } else {
                    int score = (maxAttempts - attempts + 1) * 10;
                    System.out.println("\nCorrect Guess!");
                    System.out.println("You guessed the number in " + attempts + " attempts.");
                    System.out.println("Your score is: " + score);
                }
                if (attempts == 3 && userGuess != randomNumber) {
                    if (randomNumber % 2 == 0) {
                        System.out.println("Hint: The number is EVEN.");
                    } else {
                        System.out.println("Hint: The number is ODD.");
                    }
                }
            }
            if (attempts == maxAttempts && userGuess != randomNumber) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + randomNumber);
            }
            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
            round++;
        }
        System.out.println("\n=================================");
        System.out.println("Thanks for playing!");
        System.out.println("=================================");
        scanner.close();
    }
}