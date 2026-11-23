package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AssignUmbrellaOnRainyDaysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void assignUmbrella(int[] rain, String[] expected) {
        var solution = new AssignUmbrellaOnRainyDays();
        assertArrayEquals(expected, solution.assignUmbrella(rain));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 1, 0, 1, 1}, new String[] {"Alice", "Bob", "None", "Alice", "Bob"}),
                Arguments.of(new int[] {0, 1, 0, 1}, new String[] {"None", "Bob", "None", "Bob"})
        );
    }

}
