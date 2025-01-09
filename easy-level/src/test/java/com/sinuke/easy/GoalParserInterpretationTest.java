package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoalParserInterpretationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void interpret(String command, String expected) {
        var goalParser = new GoalParserInterpretation();
        assertEquals(expected, goalParser.interpret(command));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("G()(al)", "Goal"),
                Arguments.of("G()()()()(al)", "Gooooal"),
                Arguments.of("(al)G(al)()()G", "alGalooG")
        );
    }

}