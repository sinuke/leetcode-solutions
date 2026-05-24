package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CamelcaseMatchingTest {

    @ParameterizedTest
    @MethodSource("testData")
    void camelMatch(String[] queries, String pattern, List<Boolean> expected) {
        assertEquals(expected, new CamelcaseMatching().camelMatch(queries, pattern));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB", List.of(true, false, true, true, false)),
                Arguments.of(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa", List.of(true, false, true, false, false)),
                Arguments.of(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBaT", List.of(false, true, false, false, false))
        );
    }

}
