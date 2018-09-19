package evo._3_consoleVsComplexPlayerTypes;

import java.util.Objects;

public class Tuple<$First, $Second> {
    private $First first;
    private $Second second;

    Tuple($First first, $Second second) {
        this.first = first;
        this.second = second;
    }

    public $First getFirst() {
        return first;
    }

    public $Second getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return Objects.equals(first, tuple.first) &&
                Objects.equals(second, tuple.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
