package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummaryRangesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void summaryRanges(int[] nums, List<String> expected) {
        var summaryRanges = new SummaryRanges();
        assertEquals(expected, summaryRanges.summaryRanges(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
                Arguments.of(new int[] {0, 2, 3, 4, 6, 8, 9}, List.of("0", "2->4", "6", "8->9")),
                Arguments.of(new int[] {}, List.of()),
                Arguments.of(new int[] {1}, List.of("1"))
        );
    }

}
