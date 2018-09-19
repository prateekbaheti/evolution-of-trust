package evo._3_consoleVsComplexPlayerTypes.player;

import evo._3_consoleVsComplexPlayerTypes.InputType;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class GrudgerPlayerBehaviour implements PlayerBehaviour, Observer {

    private List<InputType> inputTypes;
    private int numberOfTimesPlayed;

    public GrudgerPlayerBehaviour(Player player) {
        player.addObserver(this);
        inputTypes = new ArrayList<>();
    }

    @Override
    public InputType getInput() {
        numberOfTimesPlayed ++ ;
        InputType inputType;
        if(numberOfTimesPlayed == 1) {
            inputType = InputType.Cooperate;
        } else {
            inputType = hasCheatedInAnyButTheVeryLastRound() ? InputType.Cheat : InputType.Cooperate;
        }
        System.out.println(inputType);
        return inputType;
    }

    private boolean hasCheatedInAnyButTheVeryLastRound() {
        int index = inputTypes.indexOf(InputType.Cheat);
        return index >-1 && index < inputTypes.size() - 1;
    }

    @Override
    public void update(Observable o, Object inputType) {
        inputTypes.add((InputType) inputType);
    }
}
