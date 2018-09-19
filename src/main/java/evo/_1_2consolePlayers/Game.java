package evo._1_2consolePlayers;

import static java.lang.String.format;

class Game {

    private final Player player1;
    private final Player player2;
    private final int numberOfRounds;

    Game(Player player1, Player player2, int numberOfRounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.numberOfRounds = numberOfRounds;
    }

    Tuple<Integer, Integer> play() {
        for(int round = 0; round < numberOfRounds; round++) {
            addScoresToPlayers(getScoreFromMachine());
            printScoresToConsole();
        }
        return new Tuple<>(player1.getScore(), player2.getScore());
    }

    private void printScoresToConsole() {
        System.out.println(format("%d, %d", player1.getScore(), player2.getScore()));
    }

    private void addScoresToPlayers(Tuple<Integer, Integer> scoreForRound) {
        player1.addScore(scoreForRound.getFirst());
        player2.addScore(scoreForRound.getSecond());
    }

    private Tuple<Integer, Integer> getScoreFromMachine() {
        return Machine.calculateScores(
                        player1.readInputFromSystemIn(),
                        player2.readInputFromSystemIn());
    }
}
