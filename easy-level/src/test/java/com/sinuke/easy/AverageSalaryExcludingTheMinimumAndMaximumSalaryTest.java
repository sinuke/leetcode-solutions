package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageSalaryExcludingTheMinimumAndMaximumSalaryTest {

    @ParameterizedTest
    @MethodSource("testData")
    void average(int[] salary, double expected) {
        var solution = new AverageSalaryExcludingTheMinimumAndMaximumSalary();
        assertEquals(expected, solution.average(salary));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4000,3000,1000,2000}, 2500.00000d),
                Arguments.of(new int[] {1000,2000,3000}, 2000.00000d)
        );
    }

}
