package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpGameIIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void canReach(int[] arr, int start, boolean expected) {
        assertEquals(expected, new JumpGameIII().canReach(arr, start));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 3, 0, 3, 1, 2}, 5, true),
                Arguments.of(new int[]{4, 2, 3, 0, 3, 1, 2}, 0, true),
                Arguments.of(new int[]{3, 0, 2, 1, 2}, 2, false)
        );
    }

}
