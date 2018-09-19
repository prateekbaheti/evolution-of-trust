package evo._1_2consolePlayers;

import evo._1_2consolePlayers.ConsoleReader;
import evo._1_2consolePlayers.Game;
import evo._1_2consolePlayers.Player;
import evo._1_2consolePlayers.Tuple;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static evo._1_2consolePlayers.InputType.Cheat;
import static evo._1_2consolePlayers.InputType.Cooperate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private ConsoleReader consoleReaderForPlayer1;

    @Mock
    private ConsoleReader consoleReaderForPlayer2;

    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        player1 = new Player(consoleReaderForPlayer1);
        player2 = new Player(consoleReaderForPlayer2);
    }

    @Test
    public void shouldReturnScoreAs0And0ForOneRoundWhenBothPlayerCheat() {
        Game game = new Game(player1, player2, 1);
        when(consoleReaderForPlayer1.readInput()).thenReturn(Cheat.toString());
        when(consoleReaderForPlayer2.readInput()).thenReturn(Cheat.toString());
        assertThat(game.play()).isEqualTo(new Tuple<>(0, 0));
    }

    @Test
    public void shouldReturnScoreAs_1And3ForOneRoundWhenPlayerOneCooperatesAndPlayer2Cheats() {
        Game game = new Game(player1, player2, 1);
        when(consoleReaderForPlayer1.readInput()).thenReturn(Cooperate.toString());
        when(consoleReaderForPlayer2.readInput()).thenReturn(Cheat.toString());
        assertThat(game.play()).isEqualTo(new Tuple<>(-1, 3));
    }

    @Test
    public void shouldAddScoresFor2RoundsToPlayers() {
        Game game = new Game(player1, player2, 2);
        when(consoleReaderForPlayer1.readInput()).thenReturn(Cooperate.toString());
        when(consoleReaderForPlayer2.readInput()).thenReturn(Cheat.toString());

        assertThat(game.play()).isEqualTo(new Tuple<>(-2, 6));
    }



}