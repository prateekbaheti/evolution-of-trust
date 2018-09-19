package evo._3_consoleVsComplexPlayerTypes.player;

import evo._3_consoleVsComplexPlayerTypes.InputType;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class DetectivePlayerBehaviour implements Observer, PlayerBehaviour {

    private static final InputType[] INITIAL_SET_OF_DEFAULT_INPUTS = {InputType.Cooperate,
            InputType.Cheat, InputType.Cooperate, InputType.Cooperate};
    private int numberOfRoundsPlayed;
    private PlayerBehaviour alwaysCheatPlayerBehaviour;
    private PlayerBehaviour copyCatBehaviour;
    private List<InputType> otherPlayersInput;

    public DetectivePlayerBehaviour(Player player) {
        alwaysCheatPlayerBehaviour = PlayerBehaviour.cheatPlayerBehaviour();
        copyCatBehaviour = PlayerBehaviour.copyCatPlayerBehaviour(player);
        otherPlayersInput = new ArrayList<>();
        player.addObserver(this);
    }

    @Override
    public InputType getInput() {
        InputType inputType;
        if(numberOfRoundsPlayed <= 3) {
            inputType = getDefaultInputForFirst4Rounds();
        } else {
            inputType = getInputForSubsequentRounds();
        }
        numberOfRoundsPlayed ++;
        System.out.println(inputType);
        return inputType;
    }

    private InputType getInputForSubsequentRounds() {
        return otherPlayersInput.contains(InputType.Cheat) ?
                copyCatBehaviour.getInput() :
                alwaysCheatPlayerBehaviour.getInput();
    }

    private InputType getDefaultInputForFirst4Rounds() {
        return INITIAL_SET_OF_DEFAULT_INPUTS[numberOfRoundsPlayed];
    }

    @Override
    public void update(Observable o, Object input) {
        otherPlayersInput.add((InputType) input);
    }
}
