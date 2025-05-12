package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheSumOfEncryptedIntegersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumOfEncryptedInt(int[] nums, int expected) {
        var solution = new FindTheSumOfEncryptedIntegers();
        assertEquals(expected, solution.sumOfEncryptedInt(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3}, 6),
                Arguments.of(new int[] {10,21,31}, 66)
        );
    }

}
