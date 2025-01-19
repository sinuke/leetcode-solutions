package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DecompressRunLengthEncodedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void decompressRLElist(int[] nums, int[] expected) {
        var decompressor = new DecompressRunLengthEncodedList();
        assertArrayEquals(expected, decompressor.decompressRLElist(nums));
        assertArrayEquals(expected, decompressor.decompressRLElist2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4}, new int[] {2,4,4,4}),
                Arguments.of(new int[] {1,1,2,3}, new int[] {1,3,3})
        );
    }

}
