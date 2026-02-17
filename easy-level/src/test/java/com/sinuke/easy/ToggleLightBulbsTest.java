package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToggleLightBulbsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void toggleLightBulbs(List<Integer> bulbs, List<Integer> expected) {
        var solution = new ToggleLightBulbs();
        assertEquals(expected, solution.toggleLightBulbs(bulbs));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(10,30,20,10), List.of(20,30)),
                Arguments.of(List.of(100,100), List.of())
        );
    }

}
