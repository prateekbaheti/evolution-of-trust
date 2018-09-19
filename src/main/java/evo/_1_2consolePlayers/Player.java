package evo._1_2consolePlayers;

class Player {

    private int score;
    private ConsoleReader consoleReader;

    Player(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    InputType readInputFromSystemIn() {
        return InputType.valueOf(consoleReader.readInput());
    }

    void addScore(int score) {
        this.score += score;
    }

    int getScore() {
        return score;
    }
}
