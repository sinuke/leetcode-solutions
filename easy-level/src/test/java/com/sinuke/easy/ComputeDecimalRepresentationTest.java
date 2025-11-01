package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ComputeDecimalRepresentationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void decimalRepresentation(int n, int[] expected) {
        var solution = new ComputeDecimalRepresentation();
        assertArrayEquals(expected, solution.decimalRepresentation(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(537, new int[] {500,30,7}),
                Arguments.of(102, new int[] {100, 2}),
                Arguments.of(6, new int[] {6})
        );
    }

}
