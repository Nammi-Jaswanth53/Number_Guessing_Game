import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=====================================");

        System.out.print("Enter Player Name: ");
        String name = sc.nextLine();

        Player player = new Player(name);
        ScoreBoard scoreBoard = new ScoreBoard();

        Game game = new Game(player, scoreBoard);

        game.start();

        sc.close();
    }
}