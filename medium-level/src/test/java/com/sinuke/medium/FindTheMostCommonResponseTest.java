package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheMostCommonResponseTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findCommonResponse(List<List<String>> responses, String expected) {
        var solution = new FindTheMostCommonResponse();
        assertEquals(expected, solution.findCommonResponse(responses));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(List.of("good","ok","good","ok"), List.of("ok","bad","good","ok","ok"), List.of("good"), List.of("bad")), "good"),
                Arguments.of(List.of(List.of("good","ok","good"), List.of("ok","bad"), List.of("bad","notsure"), List.of("great","good")), "bad")
        );
    }

}
