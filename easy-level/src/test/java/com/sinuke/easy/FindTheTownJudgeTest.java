package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheTownJudgeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findJudge(int n, int[][] trust, int expected) {
        var solution = new FindTheTownJudge();
        assertEquals(expected, solution.findJudge(n, trust));
        assertEquals(expected, solution.findJudge2(n, trust));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, new int[][] {{1,2}}, 2),
                Arguments.of(3, new int[][] {{1,3},{2,3}}, 3),
                Arguments.of(3, new int[][] {{1,3},{2,3},{3,1}}, -1)
        );
    }

}
