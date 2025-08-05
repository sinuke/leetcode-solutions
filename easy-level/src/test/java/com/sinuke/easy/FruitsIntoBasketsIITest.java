package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FruitsIntoBasketsIITest {

    @ParameterizedTest()
    @MethodSource("testData")
    void numOfUnplacedFruits(int[] fruits, int[] baskets, int expected) {
        var solution = new FruitsIntoBasketsII();
        assertEquals(expected, solution.numOfUnplacedFruits(fruits, baskets));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,2,5}, new int[] {3,5,4}, 1),
                Arguments.of(new int[] {3,6,1}, new int[] {6,4,7}, 0)
        );
    }

}
