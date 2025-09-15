package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindTheOriginalArrayOfPrefixXorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findArray(int[] pref, int[] expected) {
        var solution = new FindTheOriginalArrayOfPrefixXor();
        assertArrayEquals(expected, solution.findArray(pref));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5,2,0,3,1}, new int[] {5,7,2,3,2}),
                Arguments.of(new int[] {13}, new int[] {13})
        );
    }

}
