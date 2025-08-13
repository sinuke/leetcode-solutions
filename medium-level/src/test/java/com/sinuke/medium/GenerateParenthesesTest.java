package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateParenthesesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void generateParenthesis(int n, List<String> expected) {
        var solution = new GenerateParentheses();
        assertEquals(new HashSet<>(expected), new HashSet<>(solution.generateParenthesis(n)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, List.of("((()))","(()())","(())()","()(())","()()()")),
                Arguments.of(1, List.of("()"))
        );
    }

}
