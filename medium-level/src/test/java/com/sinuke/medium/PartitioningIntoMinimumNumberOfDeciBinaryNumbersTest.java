package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minPartitions(String n, int expected) {
        assertEquals(expected, new PartitioningIntoMinimumNumberOfDeciBinaryNumbers().minPartitions(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("32", 3),
                Arguments.of("82734", 8),
                Arguments.of("27346209830709182346", 9)
        );
    }

}
