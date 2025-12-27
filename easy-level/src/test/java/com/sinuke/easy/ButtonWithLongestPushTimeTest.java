package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ButtonWithLongestPushTimeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void buttonWithLongestTime(int[][] events, int expected) {
        var solution = new ButtonWithLongestPushTime();
        assertEquals(expected, solution.buttonWithLongestTime(events));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2},{2,5},{3,9},{1,15}}, 1),
                Arguments.of(new int[][] {{10,5},{1,7}}, 10),
                Arguments.of(new int[][] {{7,1},{19,3},{9,4},{12,5},{2,8},{15,10},{18,12},{7,14},{19,16}}, 2)
        );
    }

}
