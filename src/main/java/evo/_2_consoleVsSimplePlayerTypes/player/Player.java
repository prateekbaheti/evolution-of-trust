package evo._2_consoleVsSimplePlayerTypes.player;

import evo._2_consoleVsSimplePlayerTypes.InputType;
import java.util.Observable;

public class Player extends Observable {

    private int score;
    private PlayerBehaviour playerBehaviour;

    public Player(PlayerBehaviour playerBehaviour) {
        this.playerBehaviour = playerBehaviour;
    }

    public InputType getInput() {
        return playerBehaviour.getInput();
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }
}
