package tpo.function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.DoubleStream;

import static java.lang.Math.atan;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ArctgTest {
    private static final double DELTA = 0.0001;

    @Test
    @DisplayName("NaN")
    void nan() {
        assertEquals(Double.NaN, Arctg.calculate(Double.NaN));
    }

    @Test
    @DisplayName("Positive infinity")
    void positiveInfinity() {
        assertEquals(Double.NaN, Arctg.calculate(Double.POSITIVE_INFINITY));
    }

    @Test
    @DisplayName("Negative infinity")
    void negativeInfinity() {
        assertEquals(Double.NaN, Arctg.calculate(Double.NEGATIVE_INFINITY));
    }

    @ParameterizedTest
    @DisplayName("Values in [-1, 1]")
    @CsvSource({
            "0,0",
            "-1.0,-0.785398",
            "-0.577350,-0.523598",
            "0.0,0.0",
            "0.577350,0.523598",
            "1.0,0.785398",
    })
    void convergingValues(double x, double expected) {
        assertEquals(expected, Arctg.calculate(x), DELTA);
    }

    public static void main(String[] args) {
        DoubleStream.of(-1, -sqrt(3) / 3, 0, sqrt(3) / 3, 1).forEach(number -> {
            System.out.println(number + "," + atan(number));
        });
    }

    @ParameterizedTest
    @DisplayName("Values not in [-1, 1]")
    @ValueSource(doubles = {-10000, -100, -1.000001, 1.000001, 100, 10000})
    void convergingValues(double x) {
        assertEquals(Double.NaN, Arctg.calculate(x));
    }
}