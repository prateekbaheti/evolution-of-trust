package evo._3_consoleVsComplexPlayerTypes.player;

import evo._3_consoleVsComplexPlayerTypes.InputType;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CopyCatPlayerBehaviour implements Observer, PlayerBehaviour {

    private List<InputType> otherPlayersLastInputs;
    private int numberOfTimesPlayed;

    public CopyCatPlayerBehaviour(Player playerToObserve) {
        playerToObserve.addObserver(this);
        otherPlayersLastInputs = new LinkedList<>();
    }

    @Override
    public void update(Observable o, Object inputType) {
        otherPlayersLastInputs.add((InputType)inputType);
    }

    @Override
    public InputType getInput() {
        numberOfTimesPlayed ++;
        InputType inputType = numberOfTimesPlayed == 1 ? InputType.Cooperate :
                otherPlayersLastInputs.get(otherPlayersLastInputs.size() - 2);
        System.out.println(inputType);
        return inputType;
    }
}
