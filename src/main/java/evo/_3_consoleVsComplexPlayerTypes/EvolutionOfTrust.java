package evo._3_consoleVsComplexPlayerTypes;

import evo._3_consoleVsComplexPlayerTypes.player.Player;

import static evo._3_consoleVsComplexPlayerTypes.player.PlayerBehaviour.consolePlayerBehaviour;
import static evo._3_consoleVsComplexPlayerTypes.player.PlayerBehaviour.grudgerPlayerBehaviour;

public class EvolutionOfTrust {
    public static void main(String[] args) {
        Player player1 = new Player(consolePlayerBehaviour());
        Player player2 = new Player(grudgerPlayerBehaviour(player1));

        new Game(player1, player2, 5).play();
    }
}
