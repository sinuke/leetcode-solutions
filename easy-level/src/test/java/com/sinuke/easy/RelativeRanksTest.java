package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RelativeRanksTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findRelativeRanks(int[] scores, String[] expected) {
        var ranks = new RelativeRanks();
        assertArrayEquals(expected, ranks.findRelativeRanks(scores));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5,4,3,2,1}, new String[] {"Gold Medal","Silver Medal","Bronze Medal","4","5"}),
                Arguments.of(new int[] {10,3,8,9,4}, new String[] {"Gold Medal","5","Bronze Medal","Silver Medal","4"})
        );
    }

}
