package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKthBitInNthBinaryStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findKthBit(int n, int k, char expected) {
        var solution = new FindKthBitInNthBinaryString();
        assertEquals(expected, solution.findKthBit(n, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, 1, '0'),
                Arguments.of(4, 11, '1')
        );
    }

}
