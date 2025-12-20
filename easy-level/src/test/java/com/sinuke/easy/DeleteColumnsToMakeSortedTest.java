package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteColumnsToMakeSortedTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minDeletionSize(String[] strs, int expected) {
        var solution = new DeleteColumnsToMakeSorted();
        assertEquals(expected, solution.minDeletionSize(strs));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"cba","daf","ghi"}, 1),
                Arguments.of(new String[] {"a","b"}, 0),
                Arguments.of(new String[] {"zyx","wvu","tsr"}, 3)
        );
    }

}
