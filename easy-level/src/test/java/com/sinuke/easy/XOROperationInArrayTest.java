package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XOROperationInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void xorOperation(int n, int start, int expected) {
        var xorOperation = new XOROperationInArray();
        assertEquals(expected, xorOperation.xorOperation(n, start));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 0, 8),
                Arguments.of(4, 3, 8)
        );
    }

}
