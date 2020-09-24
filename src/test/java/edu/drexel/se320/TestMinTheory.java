package edu.drexel.se320;

import edu.drexel.se320.Min;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.stream.Stream;

public class TestMinTheory {

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -4, 0, 6, Integer.MAX_VALUE})
    public void testMinTheories(int a, int b){
        int c = Min.min(a,b);
        assertTrue(c <= a, "min less than first argument");
        assertTrue(c <= b, "min less than second argument");
        assertTrue(c == a || c == b, "min is one of the arguments");
    }


    @ParameterizedTest
    @MethodSource("provideSomeOddTests")
    void testOdd(int input, boolean expected) {
        assertEquals(expected, input % 2 == 1);
    }

    private static Stream<Arguments> provideSomeOddTests() {
        return Stream.of(
          Arguments.of(2, false),
          Arguments.of(4, false),
          Arguments.of(3, true),
          Arguments.of(5, true)
        );
    }

}
