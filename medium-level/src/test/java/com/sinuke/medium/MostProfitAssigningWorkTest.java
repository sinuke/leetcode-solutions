package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MostProfitAssigningWorkTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxProfitAssignment(int[] difficulty, int[] profit, int[] worker, int expected) {
        assertEquals(expected, new MostProfitAssigningWork().maxProfitAssignment(difficulty, profit, worker));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7}, 100),
                Arguments.of(new int[]{85, 47, 57}, new int[]{24, 66, 99}, new int[]{40, 25, 25}, 0)
        );
    }

}
