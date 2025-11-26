package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrongPasswordCheckerIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void strongPasswordCheckerII(String password, boolean expected) {
        var solution = new StrongPasswordCheckerII();
        assertEquals(expected, solution.strongPasswordCheckerII(password));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("IloveLe3tcode!", true),
                Arguments.of("Me+You--IsMyDream", false),
                Arguments.of("1aB!", false)
        );
    }

}
