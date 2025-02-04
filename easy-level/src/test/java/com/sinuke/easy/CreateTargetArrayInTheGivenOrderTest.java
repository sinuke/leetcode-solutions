package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CreateTargetArrayInTheGivenOrderTest {

    @ParameterizedTest
    @MethodSource("testData")
    void createTargetArray(int[] nums, int[] index, int[] expected) {
        var createTargetArray = new CreateTargetArrayInTheGivenOrder();
        assertArrayEquals(expected, createTargetArray.createTargetArray(nums, index));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,1,2,3,4}, new int[] {0,1,2,2,1}, new int[] {0,4,1,3,2}),
                Arguments.of(new int[] {1,2,3,4,0}, new int[] {0,1,2,3,0}, new int[] {0,1,2,3,4}),
                Arguments.of(new int[] {1}, new int[] {0}, new int[] {1})
        );
    }

}
