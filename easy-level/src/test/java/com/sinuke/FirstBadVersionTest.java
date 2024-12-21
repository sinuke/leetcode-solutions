package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstBadVersionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void firstBadVersion(int n, int bad) {
        var firstBadVersion = new FirstBadVersion(n, bad);
        assertEquals(bad, firstBadVersion.firstBadVersion(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 4),
                Arguments.of(1, 1),
                Arguments.of(3, 3),
                Arguments.of(2126753390, 1702766719)
        );
    }

}
