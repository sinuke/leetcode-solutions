package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTestedDevicesAfterTestOperationsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countTestedDevices(int[] batteryPercentages, int expected) {
        var solution = new CountTestedDevicesAfterTestOperations();
        assertEquals(expected, solution.countTestedDevices(batteryPercentages));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,2,1,3}, 3),
                Arguments.of(new int[] {0,1,2}, 2)
        );
    }

}
