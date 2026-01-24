package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DetermineIfTwoEventsHaveConflictTest {

    @ParameterizedTest
    @MethodSource("testData")
    void haveConflict(String[] event1, String[] event2, boolean expected) {
        var solution = new DetermineIfTwoEventsHaveConflict();
        assertEquals(expected, solution.haveConflict(event1, event2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"01:15","02:00"}, new String[] {"02:00","03:00"}, true),
                Arguments.of(new String[] {"01:00","02:00"}, new String[] {"01:20","03:00"}, true),
                Arguments.of(new String[] {"10:00","11:00"}, new String[] {"14:00","15:00"}, false)
        );
    }

}
