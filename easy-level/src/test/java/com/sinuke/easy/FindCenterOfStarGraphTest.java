package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindCenterOfStarGraphTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findCenter(int[][] edges, int expected) {
        var finder = new FindCenterOfStarGraph();
        assertEquals(expected, finder.findCenter(edges));
        assertEquals(expected, finder.findCenter2(edges));
        assertEquals(expected, finder.findCenter3(edges));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2},{2,3},{4,2}}, 2),
                Arguments.of(new int[][] {{1,2},{5,1},{1,3},{1,4}}, 1)
        );
    }

}
