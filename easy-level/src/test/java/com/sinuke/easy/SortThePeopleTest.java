package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortThePeopleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortPeople(String[] names, int[] heights, String[] expected) {
        var sorter = new SortThePeople();
        assertArrayEquals(expected, sorter.sortPeople(names, heights));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"Mary","John","Emma"}, new int[] {180,165,170}, new String[] {"Mary","Emma","John"}),
                Arguments.of(new String[] {"Alice","Bob","Bob"}, new int[] {155,185,150}, new String[] {"Bob","Alice","Bob"})
        );
    }

}
