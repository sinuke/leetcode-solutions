package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConvertTemperatureTest {

    @ParameterizedTest
    @MethodSource("testData")
    void convertTemperature(double celsius, double[] expected) {
        var convert = new ConvertTemperature();
        assertArrayEquals(expected, convert.convertTemperature(celsius));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(36.50d, new double[] {309.65000d,97.70000d}),
                Arguments.of(122.11d, new double[] {395.26000d,251.79800d})
        );
    }

}
