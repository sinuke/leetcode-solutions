package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReplaceElementsWithGreatestElementOnRightSideTest {

    @ParameterizedTest
    @MethodSource("testData")
    void replaceElements(int[] arr, int[] expected) {
        var solution = new ReplaceElementsWithGreatestElementOnRightSide();
        assertArrayEquals(expected, solution.replaceElements(arr));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {17,18,5,4,6,1}, new int[] {18,6,6,6,1,-1}),
                Arguments.of(new int[] {400}, new int[] {-1})
        );
    }

}
