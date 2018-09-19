package evo._3_consoleVsComplexPlayerTypes.player;

import evo._3_consoleVsComplexPlayerTypes.InputType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static evo._3_consoleVsComplexPlayerTypes.InputType.Cheat;
import static evo._3_consoleVsComplexPlayerTypes.InputType.Cooperate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GrudgerPlayerBehaviourTest {

    @Mock
    private Player player;

    @Test
    public void shouldReturnCooperateTheFirstTime() {
        GrudgerPlayerBehaviour grudgerPlayerBehaviour = new GrudgerPlayerBehaviour(player);
        assertThat(grudgerPlayerBehaviour.getInput()).isEqualTo(Cooperate);
    }

    @Test
    public void shouldReturnCheatIfYouCheatEvenOnce() {
        GrudgerPlayerBehaviour grudgerPlayerBehaviour = new GrudgerPlayerBehaviour(player);
        assertThat(grudgerPlayerBehaviour.getInput()).isEqualTo(Cooperate);

        grudgerPlayerBehaviour.update(player, Cheat);

        assertThat(grudgerPlayerBehaviour.getInput()).isEqualTo(Cheat);
    }

    @Test
    public void shouldAlwaysReturnCooperateTheFirstTimeEvenIfUpdateWasCalledFirstBeforeInput() {
        GrudgerPlayerBehaviour grudgerPlayerBehaviour = new GrudgerPlayerBehaviour(player);
        grudgerPlayerBehaviour.update(player, Cheat);
        assertThat(grudgerPlayerBehaviour.getInput()).isEqualTo(Cooperate);
    }

    @Test
    public void shouldReturnCooperateTheSecondTimeIfOtherPlayerCheatedInTheThirdRound() {
        GrudgerPlayerBehaviour grudgerPlayerBehaviour = new GrudgerPlayerBehaviour(player);
        grudgerPlayerBehaviour.update(player, Cooperate);
        grudgerPlayerBehaviour.getInput();
        grudgerPlayerBehaviour.update(player, Cooperate);
        grudgerPlayerBehaviour.getInput();
        grudgerPlayerBehaviour.update(player, Cheat);
        assertThat(grudgerPlayerBehaviour.getInput()).isEqualTo(Cooperate);
    }

    @Test
    public void shouldAddItselfAsObserverToPlayerWhenConstructed() {
        GrudgerPlayerBehaviour grudgerPlayerBehaviour = new GrudgerPlayerBehaviour(player);
        verify(player).addObserver(grudgerPlayerBehaviour);
    }
}