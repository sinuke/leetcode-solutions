package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalValueOfVariableAfterPerformingOperationsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void finalValueAfterOperations(String[] operations, int expected) {
        var finalValue = new FinalValueOfVariableAfterPerformingOperations();
        assertEquals(expected, finalValue.finalValueAfterOperations(operations));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"--X","X++","X++"}, 1),
                Arguments.of(new String[] {"++X","++X","X++"}, 3),
                Arguments.of(new String[] {"X++","++X","--X","X--"}, 0)
        );
    }

}