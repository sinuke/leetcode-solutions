package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DistributeCandiesToPeopleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void distributeCandies(int candies, int num_people, int[] expected) {
        var solution = new DistributeCandiesToPeople();
        assertArrayEquals(expected, solution.distributeCandies(candies, num_people));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(7, 4, new int[] {1,2,3,1}),
                Arguments.of(10, 3, new int[] {5,2,3})
        );
    }

}
