package evo._2_consoleVsSimplePlayerTypes.player;

import evo._2_consoleVsSimplePlayerTypes.InputType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    @Mock
    private PlayerBehaviour playerBehaviour;

    @Test
    public void shouldReturnInputTypeCheatWhenPlayerBehaviourReturnsCheat() {
        when(playerBehaviour.getInput()).thenReturn(InputType.Cheat);
        Player player = new Player(playerBehaviour);
        InputType inputType = player.getInput();
        assertThat(inputType).isEqualTo(InputType.Cheat);
    }

    @Test
    public void shouldAddScoreToPlayerAndReturnFinalScoreAs3() {
        Player player = new Player(playerBehaviour);
        player.addScore(2);
        assertThat(player.getScore()).isEqualTo(2);
        player.addScore(2);
        assertThat(player.getScore()).isEqualTo(4);
    }
}