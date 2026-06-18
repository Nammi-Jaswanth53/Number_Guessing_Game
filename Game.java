import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Player player;
    private final ScoreBoard scoreBoard;

    public Game(Player player, ScoreBoard scoreBoard) {
        this.player = player;
        this.scoreBoard = scoreBoard;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {

            scoreBoard.gamePlayed();

            System.out.println("\n=====================================");
            System.out.println("        NUMBER GUESSING GAME");
            System.out.println("=====================================");
            System.out.println("Welcome " + player.getName());

            System.out.println("\nChoose Difficulty Level");
            System.out.println("1. Easy   (10 Attempts)");
            System.out.println("2. Medium (5 Attempts)");
            System.out.println("3. Hard   (3 Attempts)");
            System.out.print("Enter the difficulty level number: ");

            int choice = sc.nextInt();

            int attempts;

            switch (choice) {
                case 1:
                    attempts = 10;
                    break;
                case 2:
                    attempts = 5;
                    break;
                case 3:
                    attempts = 3;
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to Medium Level.");
                    attempts = 5;
            }

            int secretNumber = random.nextInt(100) + 1;
            boolean won = false;

            System.out.println("\n=====================================");
            System.out.println("A number has been chosen by the system.");
            System.out.println("The number is between 1 and 100.");
            System.out.println("You have " + attempts + " attempts.");
            System.out.println("Try to guess the number!");
            System.out.println("=====================================");

            for (int i = 1; i <= attempts; i++) {

                System.out.println("\nAttempt " + i + " of " + attempts);
                System.out.print("Enter your guess: ");

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    i--;
                    continue;
                }

                if (guess == secretNumber) {

                    int score = ((attempts - i + 1) * 10) + 50;

                    player.addScore(score);
                    scoreBoard.gameWon();

                    System.out.println("\n🎉 Congratulations " + player.getName() + "!");
                    System.out.println("You guessed the correct number.");
                    System.out.println("Secret Number : " + secretNumber);
                    System.out.println("Score Earned  : " + score);

                    won = true;
                    break;
                }

                int diff = Math.abs(secretNumber - guess);

                if (diff <= 3) {
                    System.out.println("🔥 Very Very Close!");
                } else if (diff <= 10) {
                    System.out.println("😊 Close!");
                } else {
                    System.out.println("❄️ Far Away!");
                }

                if (guess > secretNumber) {
                    System.out.println("Your guessed number is HIGHER than the secret number.");
                } else {
                    System.out.println("Your guessed number is LOWER than the secret number.");
                }

                System.out.println("Attempts Remaining: " + (attempts - i));
            }

            if (!won) {
                System.out.println("\n❌ You have used all attempts.");
                System.out.println("Better luck next time!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.println("\nDo you want to play again?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");

            int option = sc.nextInt();

            if (option != 1) {
                playAgain = false;
            }
        }

        System.out.println("\n=====================================");
        System.out.println("Player Name : " + player.getName());
        System.out.println("Total Score : " + player.getTotalScore());
        System.out.println("=====================================");

        scoreBoard.displayStats();

        System.out.println("\nThank you for playing!");
        sc.close();
    }
}