package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HammingDistanceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hammingDistance(int x, int y, int expected) {
        var harmingDistance = new HammingDistance();
        assertEquals(expected, harmingDistance.hammingDistance(x, y));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 4, 2),
                Arguments.of(3, 1, 1)

        );
    }

}