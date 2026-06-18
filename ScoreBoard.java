public class ScoreBoard {

    private int gamesPlayed;
    private int gamesWon;

    public void gamePlayed() {
        gamesPlayed++;
    }

    public void gameWon() {
        gamesWon++;
    }

    public void displayStats() {

        System.out.println("\n========== GAME STATISTICS ==========");
        System.out.println("Games Played : " + gamesPlayed);
        System.out.println("Games Won    : " + gamesWon);
        System.out.println("Games Lost   : " + (gamesPlayed - gamesWon));

        double winPercentage =
                ((double) gamesWon / gamesPlayed) * 100;

        System.out.printf("Win Percentage : %.2f%%\n", winPercentage);
        System.out.println("=====================================");
    }
}