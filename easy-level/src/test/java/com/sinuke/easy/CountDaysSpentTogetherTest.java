package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountDaysSpentTogetherTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob, int expected) {
        var solution = new CountDaysSpentTogether();
        assertEquals(expected, solution.countDaysTogether(arriveAlice,  leaveAlice, arriveBob, leaveBob));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("08-15", "08-18", "08-16", "08-19", 3),
                Arguments.of("10-01", "10-31", "11-01", "12-31", 0)
        );
    }

}
