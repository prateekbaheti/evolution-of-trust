package evo._1_2consolePlayers;

import java.util.Arrays;

import static evo._1_2consolePlayers.InputType.Cheat;
import static evo._1_2consolePlayers.InputType.Cooperate;

enum Machine {

    CHEAT_CHEAT(new Tuple<>(Cheat, Cheat), new Tuple<>(0, 0)),
    CHEAT_COOPERATE(new Tuple<>(Cheat, Cooperate), new Tuple<>(3, -1)),
    COOPERATE_CHEAT(new Tuple<>(Cooperate, Cheat), new Tuple<>(-1, 3)),
    COOPERATE_COOPERATE(new Tuple<>(Cooperate, Cooperate), new Tuple<>(2, 2));

    private final Tuple<InputType, InputType> playerInputs;
    private final Tuple<Integer, Integer> playerScores;

    Machine(Tuple<InputType, InputType> playerInputs, Tuple<Integer, Integer> playerScores) {
        this.playerInputs = playerInputs;
        this.playerScores = playerScores;
    }

    public static Tuple<Integer, Integer> calculateScores(InputType firstPlayerInput,
                                                          InputType secondPlayerInput) {
        Tuple<InputType, InputType> playerInputTuple = new Tuple<>(firstPlayerInput, secondPlayerInput);
        Machine machineState = Arrays.stream(Machine.values()).filter(machine ->
            machine.playerInputs.equals(playerInputTuple)
        ).findFirst().orElseThrow(IllegalStateException::new);
        return machineState.playerScores;
    }
}
