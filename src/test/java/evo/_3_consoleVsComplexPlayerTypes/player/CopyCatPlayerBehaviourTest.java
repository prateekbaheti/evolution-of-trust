package evo._3_consoleVsComplexPlayerTypes.player;

import evo._3_consoleVsComplexPlayerTypes.InputType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CopyCatPlayerBehaviourTest {

    @Mock
    private Player player;

    @Test
    public void shouldReturnCooperateAsInput() {
        CopyCatPlayerBehaviour copyCatPlayerBehaviour = new CopyCatPlayerBehaviour(player);
        assertThat(copyCatPlayerBehaviour.getInput()).isEqualTo(InputType.Cooperate);
    }

    @Test
    public void shouldReturnCheatTheSecondTimeAsThatWasPassedIntoUpdateObserver() {
        CopyCatPlayerBehaviour copyCatPlayerBehaviour = new CopyCatPlayerBehaviour(player);
        assertThat(copyCatPlayerBehaviour.getInput()).isEqualTo(InputType.Cooperate);
        copyCatPlayerBehaviour.update(player, InputType.Cheat);
        assertThat(copyCatPlayerBehaviour.getInput()).isEqualTo(InputType.Cheat);
    }

    @Test
    public void shouldReturnCooperateTheFirstTimeEvenThoughUpdateWasCalledBeforeGetInput() {
        CopyCatPlayerBehaviour copyCatPlayerBehaviour = new CopyCatPlayerBehaviour(player);
        copyCatPlayerBehaviour.update(player, InputType.Cheat);
        assertThat(copyCatPlayerBehaviour.getInput()).isEqualTo(InputType.Cooperate);
        assertThat(copyCatPlayerBehaviour.getInput()).isEqualTo(InputType.Cheat);
    }

    @Test
    public void shouldReturnCheatTheSecondTimeEvenThoughTheSecondInputByOtherPlayerWasCooperate() {
        CopyCatPlayerBehaviour copyCatPlayerBehaviour = new CopyCatPlayerBehaviour(player);
        copyCatPlayerBehaviour.update(player, InputType.Cheat);
        assertThat(copyCatPlayerBehaviour.getInput()).isEqualTo(InputType.Cooperate);
        copyCatPlayerBehaviour.update(player, InputType.Cooperate);
        assertThat(copyCatPlayerBehaviour.getInput()).isEqualTo(InputType.Cheat);
    }

    @Test
    public void shouldAddItselfAsObserverToPlayerWhenConstructed() {
        CopyCatPlayerBehaviour copyCatPlayerBehaviour = new CopyCatPlayerBehaviour(player);
        verify(player).addObserver(copyCatPlayerBehaviour);
    }
}