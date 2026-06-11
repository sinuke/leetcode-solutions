package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistributeCandiesAmongChildrenITest {

    @ParameterizedTest
    @MethodSource("testData")
    void distributeCandies(int n, int limit, int expected) {
        assertEquals(expected, new DistributeCandiesAmongChildrenI().distributeCandies(n, limit));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 2, 3),
                Arguments.of(3, 3, 10)
        );
    }

}
