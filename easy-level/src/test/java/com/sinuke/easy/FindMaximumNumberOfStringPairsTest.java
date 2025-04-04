package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMaximumNumberOfStringPairsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximumNumberOfStringPairs(String[] words, int expected) {
        var solution = new FindMaximumNumberOfStringPairs();
        assertEquals(expected, solution.maximumNumberOfStringPairs(words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"cd","ac","dc","ca","zz"}, 2),
                Arguments.of(new String[] {"ab","ba","cc"}, 1),
                Arguments.of(new String[] {"aa","ab"}, 0)
        );
    }

}
