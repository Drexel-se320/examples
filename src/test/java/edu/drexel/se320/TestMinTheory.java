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
