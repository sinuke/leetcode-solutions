package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RestoreFinishingOrderTest {

    @ParameterizedTest
    @MethodSource("testData")
    void recoverOrder(int[] order, int[] friends, int[] expected) {
        var solution = new RestoreFinishingOrder();
        assertArrayEquals(expected, solution.recoverOrder(order, friends));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,1,2,5,4}, new int[] {1,3,4}, new int[] {3,1,4}),
                Arguments.of(new int[] {1,4,5,3,2}, new int[] {2,5}, new int[] {5,2})
        );
    }

}
