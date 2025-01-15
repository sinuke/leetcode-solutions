package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DecodeXORedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void decode(int[] encoded, int first, int[] expected) {
        var decoder = new DecodeXORedArray();
        assertArrayEquals(expected, decoder.decode(encoded, first));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3}, 1, new int[] {1,0,2,1}),
                Arguments.of(new int[] {6,2,7,3}, 4, new int[] {4,2,0,7,4})
        );
    }

}
