package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotReturnToOriginTest {

    @ParameterizedTest
    @MethodSource("testData")
    void judgeCircle(String moves, boolean expected) {
        var robot = new RobotReturnToOrigin();
        assertEquals(expected, robot.judgeCircle(moves));
        assertEquals(expected, robot.judgeCircle2(moves));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("UD", true),
                Arguments.of("RDLLUURD", true),
                Arguments.of("LL", false)
        );
    }

}
