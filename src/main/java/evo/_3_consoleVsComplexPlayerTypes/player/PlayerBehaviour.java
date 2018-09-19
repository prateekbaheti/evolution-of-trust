package evo._3_consoleVsComplexPlayerTypes.player;

import evo._3_consoleVsComplexPlayerTypes.InputType;

import static evo._3_consoleVsComplexPlayerTypes.InputType.Cheat;
import static evo._3_consoleVsComplexPlayerTypes.InputType.Cooperate;


@FunctionalInterface
public interface PlayerBehaviour {
    InputType getInput();

    static PlayerBehaviour cooperatePlayerBehaviour() {
        return () -> {
            System.out.println(Cooperate);
            return Cooperate;
        };
    }

    static PlayerBehaviour cheatPlayerBehaviour() {
        return () -> {
            System.out.println(Cheat);
            return Cheat;
        };
    }

    static PlayerBehaviour consolePlayerBehaviour() {
        return new ConsolePlayerBehaviour();
    }

    static PlayerBehaviour copyCatPlayerBehaviour(Player otherPlayerToCopy) {
        return new CopyCatPlayerBehaviour(otherPlayerToCopy);
    }

    static PlayerBehaviour detectivePlayerBehaviour(Player otherPlayerToCopy) {
        return new DetectivePlayerBehaviour(otherPlayerToCopy);
    }

    static PlayerBehaviour grudgerPlayerBehaviour(Player otherPlayerToCopy) {
        return new GrudgerPlayerBehaviour(otherPlayerToCopy);
    }
}
