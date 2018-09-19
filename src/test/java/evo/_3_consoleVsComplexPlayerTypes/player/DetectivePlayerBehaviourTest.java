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
public class DetectivePlayerBehaviourTest {
    @Mock
    private Player player;

    @Test
    public void shouldReturnCoopeateAsTheFirstInput() {
        assertThat(new DetectivePlayerBehaviour(player).getInput()).isEqualTo(Cooperate);
    }

    @Test
    public void shouldReturnCheatAsTheSecondInput() {
        DetectivePlayerBehaviour detectivePlayerBehaviour = new DetectivePlayerBehaviour(player);
        detectivePlayerBehaviour.getInput();
        assertThat(detectivePlayerBehaviour.getInput()).isEqualTo(Cheat);
    }

    @Test
    public void shouldReturnCooperateAsTheThirdInput() {
        DetectivePlayerBehaviour detectivePlayerBehaviour = new DetectivePlayerBehaviour(player);
        detectivePlayerBehaviour.getInput();
        detectivePlayerBehaviour.getInput();
        assertThat(detectivePlayerBehaviour.getInput()).isEqualTo(Cooperate);
    }

    @Test
    public void shouldReturnCooperateAsTheFourthInput() {
        DetectivePlayerBehaviour detectivePlayerBehaviour = new DetectivePlayerBehaviour(player);
        detectivePlayerBehaviour.getInput();
        detectivePlayerBehaviour.getInput();
        detectivePlayerBehaviour.getInput();
        assertThat(detectivePlayerBehaviour.getInput()).isEqualTo(Cooperate);
    }

    @Test
    public void shouldReturnCheatAsTheFifthInputSinceOtherPlayerNeverCheated() {
        DetectivePlayerBehaviour detectivePlayerBehaviour = new DetectivePlayerBehaviour(player);
        runThrough4Inputs(detectivePlayerBehaviour,
                new InputType[]{Cooperate, Cooperate, Cooperate, Cooperate});
        assertThat(detectivePlayerBehaviour.getInput()).isEqualTo(Cheat);
    }

    @Test
    public void shouldReturnCooperateAsTheFifthInputAsCopyCatBehaviour() {
        DetectivePlayerBehaviour detectivePlayerBehaviour = new DetectivePlayerBehaviour(player);
        runThrough4Inputs(detectivePlayerBehaviour,
                new InputType[]{Cooperate, Cheat, Cooperate, Cooperate});
        assertThat(detectivePlayerBehaviour.getInput()).isEqualTo(Cooperate);
    }

    @Test
    public void shouldAddItselfAsObserverToPlayerWhenConstructed() {
        DetectivePlayerBehaviour detectivePlayerBehaviour = new DetectivePlayerBehaviour(player);
        verify(player).addObserver(detectivePlayerBehaviour);
    }

    private void runThrough4Inputs(DetectivePlayerBehaviour detectivePlayerBehaviour,
                                   InputType[] otherPlayerInputs) {
        for (InputType otherPlayerInput : otherPlayerInputs) {
            detectivePlayerBehaviour.update(player, otherPlayerInput);
            detectivePlayerBehaviour.getInput();
        }
    }
}