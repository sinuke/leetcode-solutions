package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSimilarItemsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeSimilarItems(int[][] items1, int[][] items2, List<List<Integer>> expected) {
        var solution = new MergeSimilarItems();
        assertEquals(expected, solution.mergeSimilarItems(items1, items2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,1},{4,5},{3,8}}, new int[][] {{3,1},{1,5}}, List.of(List.of(1,6), List.of(3,9), List.of(4,5))),
                Arguments.of(new int[][] {{1,1},{3,2},{2,3}}, new int[][] {{2,1},{3,2},{1,3}}, List.of(List.of(1,4), List.of(2,4), List.of(3,4))),
                Arguments.of(new int[][] {{1,3},{2,2}}, new int[][] {{7,1},{2,2},{1,4}}, List.of(List.of(1,7), List.of(2,4), List.of(7,1)))
        );
    }

}
