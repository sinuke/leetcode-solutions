package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DividePlayersIntoTeamsOfEqualSkillTest {

    @ParameterizedTest
    @MethodSource("testData")
    void dividePlayers(int[] skill, long expected) {
        assertEquals(expected, new DividePlayersIntoTeamsOfEqualSkill().dividePlayers(skill));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 5, 1, 3, 4}, 22L),
                Arguments.of(new int[]{3, 4}, 12L),
                Arguments.of(new int[]{1, 1, 2, 3}, -1L)
        );
    }

}
