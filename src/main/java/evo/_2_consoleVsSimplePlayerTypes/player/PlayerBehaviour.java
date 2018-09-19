package evo._2_consoleVsSimplePlayerTypes.player;

import evo._2_consoleVsSimplePlayerTypes.InputType;

import static evo._2_consoleVsSimplePlayerTypes.InputType.Cheat;
import static evo._2_consoleVsSimplePlayerTypes.InputType.Cooperate;

@FunctionalInterface
public interface PlayerBehaviour {
    InputType getInput();

    static PlayerBehaviour cooperatePlayerBehaviour() {
        return () -> Cooperate;
    }

    static PlayerBehaviour cheatPlayerBehaviour() {
        return () -> Cheat;
    }

    static PlayerBehaviour consolePlayerBehaviour() {
        return new ConsolePlayerBehaviour();
    }
}
