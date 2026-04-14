package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrafficSignalColorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void trafficSignal(int timer, String expected) {
        assertEquals(expected, new TrafficSignalColor().trafficSignal(timer));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(60, "Red"),
                Arguments.of(5, "Invalid"),
                Arguments.of(0, "Green"),
                Arguments.of(30, "Orange")
        );
    }

}
