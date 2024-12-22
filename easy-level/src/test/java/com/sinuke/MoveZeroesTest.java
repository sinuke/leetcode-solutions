package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZeroesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void moveZeroes(int[] nums, int[] expected) {
        var moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,1,0,3,12}, new int[] {1,3,12,0,0}),
                Arguments.of(new int[] {0}, new int[] {0})
        );
    }

}
