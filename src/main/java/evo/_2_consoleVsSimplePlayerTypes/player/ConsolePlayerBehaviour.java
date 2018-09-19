package evo._2_consoleVsSimplePlayerTypes.player;

import evo._2_consoleVsSimplePlayerTypes.InputType;

import java.util.Scanner;

public class ConsolePlayerBehaviour implements PlayerBehaviour {

    @Override
    public InputType getInput() {
        Scanner scanner = new Scanner(System.in);
        return InputType.valueOf(scanner.next());
    }
}
