package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoatsToSavePeopleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numRescueBoats(int[] people, int limit, int expected) {
        assertEquals(expected, new BoatsToSavePeople().numRescueBoats(people, limit));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, 3, 1),
                Arguments.of(new int[]{3, 2, 2, 1}, 3, 3),
                Arguments.of(new int[]{3, 5, 3, 4}, 5, 4)
        );
    }

}
