package evo._2_consoleVsSimplePlayerTypes.player;

import evo._2_consoleVsSimplePlayerTypes.InputType;
import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsolePlayerBehaviourTest {

    @Test
    public void shouldReturnStringFromConsole() {
        setInputInSystemIn("Cheat");
        ConsolePlayerBehaviour consolePlayerBehaviour = new ConsolePlayerBehaviour();
        assertThat(consolePlayerBehaviour.getInput()).isEqualTo(InputType.Cheat);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenInputIsNotCorrect() {
        setInputInSystemIn("Incorrect Input");
        ConsolePlayerBehaviour consolePlayerBehaviour = new ConsolePlayerBehaviour();
        consolePlayerBehaviour.getInput();
    }

    private void setInputInSystemIn(String cheat) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cheat.getBytes());
        System.setIn(byteArrayInputStream);
    }

    @After
    public void resetSystemInputStream() {
        System.setIn(System.in);
    }
}