package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateTagForVideoCaptionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void generateTag(String caption, String expected) {
        var solution = new GenerateTagForVideoCaption();
        assertEquals(expected, solution.generateTag(caption));
        assertEquals(expected, solution.generateTag2(caption));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Leetcode daily streak achieved", "#leetcodeDailyStreakAchieved"),
                Arguments.of("can I Go There", "#canIGoThere"),
                Arguments.of("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh", "#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"),
                Arguments.of(" a", "#a"),
                Arguments.of(" ", "#")
        );
    }

}
