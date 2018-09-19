package evo._3_consoleVsComplexPlayerTypes.player;

import evo._3_consoleVsComplexPlayerTypes.InputType;

import java.util.Scanner;

public class ConsolePlayerBehaviour implements PlayerBehaviour {

    @Override
    public InputType getInput() {
        Scanner scanner = new Scanner(System.in);
        return InputType.valueOf(scanner.next());
    }
}
