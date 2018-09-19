package evo._3_consoleVsComplexPlayerTypes.player;

import evo._3_consoleVsComplexPlayerTypes.InputType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Observer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    @Mock
    private PlayerBehaviour playerBehaviour;

    @Mock
    private Observer playerInputObserver;

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

    @Test
    public void shouldNotifyObserverWhenPlayerProvidesInput() {
        Player player = new Player(playerBehaviour);
        player.addObserver(playerInputObserver);
        when(playerBehaviour.getInput()).thenReturn(InputType.Cheat);

        player.getInput();

        verify(playerInputObserver).update(player, InputType.Cheat);
    }
}