package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlternatingGroupsITest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfAlternatingGroups(int[] colors, int expected) {
        var solution = new AlternatingGroupsI();
        assertEquals(expected, solution.numberOfAlternatingGroups(colors));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,1}, 0),
                Arguments.of(new int[] {0,1,0,0,1}, 3)
        );
    }

}
