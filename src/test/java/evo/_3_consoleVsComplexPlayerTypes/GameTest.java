package evo._3_consoleVsComplexPlayerTypes;

import evo._3_consoleVsComplexPlayerTypes.player.ConsolePlayerBehaviour;
import evo._3_consoleVsComplexPlayerTypes.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static evo._3_consoleVsComplexPlayerTypes.InputType.Cheat;
import static evo._3_consoleVsComplexPlayerTypes.InputType.Cooperate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private ConsolePlayerBehaviour consolePlayerForPlayerBehaviour1;

    @Mock
    private ConsolePlayerBehaviour consolePlayerForPlayerBehaviour2;

    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        player1 = new Player(consolePlayerForPlayerBehaviour1);
        player2 = new Player(consolePlayerForPlayerBehaviour2);
    }

    @Test
    public void shouldReturnScoreAs0And0ForOneRoundWhenBothPlayerCheat() {
        Game game = new Game(player1, player2, 1);
        when(consolePlayerForPlayerBehaviour1.getInput()).thenReturn(Cheat);
        when(consolePlayerForPlayerBehaviour2.getInput()).thenReturn(Cheat);
        assertThat(game.play()).isEqualTo(new Tuple<>(0, 0));
    }

    @Test
    public void shouldReturnScoreAs_1And3ForOneRoundWhenPlayerOneCooperatesAndPlayer2Cheats() {
        Game game = new Game(player1, player2, 1);
        when(consolePlayerForPlayerBehaviour1.getInput()).thenReturn(Cooperate);
        when(consolePlayerForPlayerBehaviour2.getInput()).thenReturn(Cheat);
        assertThat(game.play()).isEqualTo(new Tuple<>(-1, 3));
    }

    @Test
    public void shouldAddScoresFor2RoundsToPlayers() {
        Game game = new Game(player1, player2, 2);
        when(consolePlayerForPlayerBehaviour1.getInput()).thenReturn(Cooperate);
        when(consolePlayerForPlayerBehaviour2.getInput()).thenReturn(Cooperate);

        assertThat(game.play()).isEqualTo(new Tuple<>(4, 4));
    }
}