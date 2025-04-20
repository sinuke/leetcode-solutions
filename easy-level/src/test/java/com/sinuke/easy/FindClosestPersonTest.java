package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindClosestPersonTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findClosest(int x,int y, int z, int expected) {
        var solution = new FindClosestPerson();
        assertEquals(expected, solution.findClosest(x,y,z));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 7, 4, 1),
                Arguments.of(2, 5, 6, 2),
                Arguments.of(1, 5, 3, 0)
        );
    }

}
