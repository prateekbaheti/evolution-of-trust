package evo._1_2consolePlayers;

import evo._1_2consolePlayers.ConsoleReader;
import evo._1_2consolePlayers.InputType;
import evo._1_2consolePlayers.Player;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    @Mock
    private ConsoleReader consoleReader;

    @Test
    public void shouldReturnInputTypeCheatWhenCheatIsEnteredInSystem() {
        when(consoleReader.readInput()).thenReturn("Cheat");
        Player player = new Player(consoleReader);
        InputType inputType = player.readInputFromSystemIn();
        assertThat(inputType).isEqualTo(InputType.Cheat);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenInputIsNotCorrect() {
        when(consoleReader.readInput()).thenReturn("Incorrect Input");
        Player player = new Player(consoleReader);
        player.readInputFromSystemIn();
    }

    @Test
    public void shouldAddScoreToPlayerAndReturnFinalScoreAs3() {
        Player player = new Player(consoleReader);
        player.addScore(2);
        assertThat(player.getScore()).isEqualTo(2);
        player.addScore(2);
        assertThat(player.getScore()).isEqualTo(4);
    }
}