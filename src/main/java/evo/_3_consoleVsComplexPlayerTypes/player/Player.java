package evo._3_consoleVsComplexPlayerTypes.player;

import evo._3_consoleVsComplexPlayerTypes.InputType;

import java.util.Observable;

public class Player extends Observable {

    private int score;
    private PlayerBehaviour playerBehaviour;

    public Player(PlayerBehaviour playerBehaviour) {
        this.playerBehaviour = playerBehaviour;
    }

    public InputType getInput() {
        InputType input = playerBehaviour.getInput();
        notifyObserversOnInput(input);
        return input;
    }

    private void notifyObserversOnInput(InputType input) {
        setChanged();
        notifyObservers(input);
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }
}
