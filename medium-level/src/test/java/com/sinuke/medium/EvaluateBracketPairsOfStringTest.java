package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluateBracketPairsOfStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void evaluate(String s, List<List<String>> knowledge, String expected) {
        var solution = new EvaluateBracketPairsOfString();
        assertEquals(expected, solution.evaluate(s, knowledge));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("(name)is(age)yearsold", List.of(List.of("name", "bob"), List.of("age", "two")), "bobistwoyearsold"),
                Arguments.of("hi(name)", List.of(List.of("a", "b")), "hi?"),
                Arguments.of("(a)(a)(a)aaa", List.of(List.of("a", "yes")), "yesyesyesaaa")
        );
    }

}
