package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DestinationCityTest {

    @ParameterizedTest
    @MethodSource("testData")
    void destCity(List<List<String>> paths, String expected) {
        var solution = new DestinationCity();
        assertEquals(expected, solution.destCity(paths));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(List.of("London","New York"),List.of("New York","Lima"),List.of("Lima","Sao Paulo")), "Sao Paulo"),
                Arguments.of(List.of(List.of("B","C"),List.of("D","B"),List.of("C","A")), "A"),
                Arguments.of(List.of(List.of("A","Z")), "Z")
        );
    }

}