package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfNAndItsDoubleExistTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkIfExist(int[] input, boolean expected) {
        var checkIfExist = new CheckIfNAndItsDoubleExist();

        assertEquals(expected, checkIfExist.checkIfExist(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {10, 2, 5, 3}, true),
                Arguments.of(new int[] {3, 1, 7, 11}, false)
        );
    }

}
