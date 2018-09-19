package evo._2_consoleVsSimplePlayerTypes;

import evo._2_consoleVsSimplePlayerTypes.player.Player;

import static evo._2_consoleVsSimplePlayerTypes.player.PlayerBehaviour.consolePlayerBehaviour;
import static evo._2_consoleVsSimplePlayerTypes.player.PlayerBehaviour.cooperatePlayerBehaviour;

public class EvolutionOfTrust {
    public static void main(String[] args) {
        Player player1 = new Player(consolePlayerBehaviour());
        Player player2 = new Player(cooperatePlayerBehaviour());

        new Game(player1, player2, 5).play();
    }
}
