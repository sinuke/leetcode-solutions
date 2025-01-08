package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfEmployeesWhoMetTheTargetTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfEmployeesWhoMetTarget(int[] hours, int target, int expected) {
        var numberOfEmployeesWhoMetTheTarget = new NumberOfEmployeesWhoMetTheTarget();
        assertEquals(expected, numberOfEmployeesWhoMetTheTarget.numberOfEmployeesWhoMetTarget(hours, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,1,2,3,4}, 2, 3),
                Arguments.of(new int[] {5,1,4,2,2}, 6, 0)
        );
    }

}
