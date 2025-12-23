package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeNeededToBuyTicketsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void timeRequiredToBuy(int[] tickets, int k, int expected) {
        var solution = new TimeNeededToBuyTickets();
        assertEquals(expected, solution.timeRequiredToBuy(tickets, k));
        assertEquals(expected, solution.timeRequiredToBuy2(tickets, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,3,2}, 2, 6),
                Arguments.of(new int[] {5,1,1,1}, 0, 8)
        );
    }

}
