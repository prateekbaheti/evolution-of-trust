package evo._2_consoleVsSimplePlayerTypes.player;

import evo._2_consoleVsSimplePlayerTypes.InputType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerBehaviourTest {

    @Test
    public void shouldReturnCooperateEveryTimeACooperatePlayerIsCalled() {
        assertThat(PlayerBehaviour.consolePlayerBehaviour().getInput()).isEqualTo(InputType.Cooperate);
    }

    @Test
    public void shouldReturnCheatEveryTimeACooperatePlayerIsCalled() {
        assertThat(PlayerBehaviour.cheatPlayerBehaviour().getInput()).isEqualTo(InputType.Cheat);
    }
}
