import java.util.Random;
import java.util.Scanner;

public class Task1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\nWelcome to the Number Game.");
        System.out.println("The system will generate a random number between 1 and 100.");
        System.out.println("Your score will be the number of attempts you took to guess the number.\n");

        System.out.print("Enter the number of rounds (between 1 and 5) you want to play the game: ");
        int rounds = scanner.nextInt();

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round + " begins ...\n");

            int randomNumber = random.nextInt(100) + 1;
            playRound(scanner, randomNumber);

            System.out.println("Round " + round + " is over.\n");
        }

        System.out.println("\nAll rounds are over. Thank you for playing the game!");
        scanner.close();
    }

    public static void playRound(Scanner scanner, int randomNumber) {
        System.out.println("Please select the difficulty level:");
        System.out.println("1 - Easy (No limit on attempts)");
        System.out.println("2 - Hard (Limited to 5 attempts)");

        int difficulty = scanner.nextInt();

        switch (difficulty) {
            case 1:
                playEasy(scanner, randomNumber);
                break;
            case 2:
                playHard(scanner, randomNumber);
                break;
            default:
                System.out.println("Invalid choice. Round wasted.");
        }
    }

    public static void playEasy(Scanner scanner, int randomNumber) {
        System.out.println("You have chosen Easy difficulty. There is no limit to the number of attempts.");

        int attempts = 0;
        while (true) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }
        }
    }

    public static void playHard(Scanner scanner, int randomNumber) {
        System.out.println("You have chosen Hard difficulty. You have 5 attempts.");

        int attempts = 0;
        final int maxAttempts = 5;
        while (attempts < maxAttempts) {
            attempts++;
            System.out.println("Attempts left: " + (maxAttempts - attempts + 1));
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return;
            } else if (guess < randomNumber) {
                System.out.println("Too low.");
            } else {
                System.out.println("Too high.");
            }
        }

        System.out.println("Sorry! You have run out of attempts. The correct number was: " + randomNumber);
    }
}
