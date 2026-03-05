package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssignCookiesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findContentChildren(int[] g, int[] s, int expected) {
        var solution = new AssignCookies();
        assertEquals(expected, solution.findContentChildren(g, s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3}, new int[] {1,1}, 1),
                Arguments.of(new int[] {1,2}, new int[] {1,2,3}, 2)
        );
    }

}
