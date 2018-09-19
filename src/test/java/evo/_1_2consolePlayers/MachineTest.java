package evo._1_2consolePlayers;

import evo._1_2consolePlayers.InputType;
import evo._1_2consolePlayers.Machine;
import evo._1_2consolePlayers.Tuple;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MachineTest {

    @Test
    public void shouldReturn3AndMinus1ForCheatAndCooperate() {
        Tuple<Integer, Integer> scoreTuple = Machine.calculateScores(InputType.Cheat, InputType.Cooperate);
        assertThat(scoreTuple).isEqualTo(new Tuple<>(3, -1));
    }

    @Test
    public void shouldReturn00ForCheatAndCheat() {
        Tuple<Integer, Integer> scoreTuple = Machine.calculateScores(InputType.Cheat, InputType.Cheat);
        assertThat(scoreTuple).isEqualTo(new Tuple<>(0, 0));
    }

    @Test
    public void shouldReturnMinus1and3ForCooperateAndCheat() {
        Tuple<Integer, Integer> scoreTuple = Machine.calculateScores(InputType.Cooperate, InputType.Cheat);
        assertThat(scoreTuple).isEqualTo(new Tuple<>(-1, 3));
    }

    @Test
    public void shouldReturn2and2ForCooperateAndCooperate() {
        Tuple<Integer, Integer> scoreTuple = Machine.calculateScores(InputType.Cooperate, InputType.Cooperate);
        assertThat(scoreTuple).isEqualTo(new Tuple<>(2, 2));
    }

}
