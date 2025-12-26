package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfPushesToTypeWordIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumPushes(String word, int expected) {
        var solution = new MinimumNumberOfPushesToTypeWordII();
        assertEquals(expected, solution.minimumPushes(word));
        assertEquals(expected, solution.minimumPushes2(word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcde", 5),
                Arguments.of("xyzxyzxyzxyz", 12),
                Arguments.of("aabbccddeeffgghhiiiiii", 24)
        );
    }

}
