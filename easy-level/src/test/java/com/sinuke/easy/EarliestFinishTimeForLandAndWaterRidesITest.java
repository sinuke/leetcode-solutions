package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EarliestFinishTimeForLandAndWaterRidesITest {

    @ParameterizedTest
    @MethodSource("testData")
    void earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration, int expected) {
        assertEquals(expected, new EarliestFinishTimeForLandAndWaterRidesI().earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 8}, new int[]{4, 1}, new int[]{6}, new int[]{3}, 9),
                Arguments.of(new int[]{5}, new int[]{3}, new int[]{1}, new int[]{10}, 14),
                Arguments.of(new int[]{99}, new int[]{59}, new int[]{99,54}, new int[]{85,20}, 158),
                Arguments.of(new int[]{94,85}, new int[]{20,54}, new int[]{20,4}, new int[]{2,35}, 114),
                Arguments.of(new int[]{31,8}, new int[]{47,64}, new int[]{3,7}, new int[]{95,44}, 98)
        );
    }

}
