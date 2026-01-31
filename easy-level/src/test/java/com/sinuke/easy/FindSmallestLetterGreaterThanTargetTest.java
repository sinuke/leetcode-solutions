package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindSmallestLetterGreaterThanTargetTest {

    @ParameterizedTest
    @MethodSource("testData")
    void nextGreatestLetter(char[] letters, char target, char expected) {
        var solution = new FindSmallestLetterGreaterThanTarget();
        assertEquals(expected, solution.nextGreatestLetter(letters, target));
        assertEquals(expected, solution.nextGreatestLetter2(letters, target));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new char[] {'c','f','j'}, 'a', 'c'),
                Arguments.of(new char[] {'c','f','j'}, 'c', 'f'),
                Arguments.of(new char[] {'x','x','y','y'}, 'z', 'x')
        );
    }

}
