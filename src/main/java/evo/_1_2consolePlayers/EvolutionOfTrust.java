package evo._1_2consolePlayers;

public class EvolutionOfTrust {
    public static void main(String[] args) {
        Player player1 = new Player(new ConsoleReader());
        Player player2 = new Player(new ConsoleReader());

        new Game(player1, player2, 5).play();
    }
}
