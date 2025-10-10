package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportSpamMessageTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reportSpam(String[] message, String[] bannedWords, boolean expected) {
        var solution = new ReportSpamMessage();
        assertEquals(expected, solution.reportSpam(message, bannedWords));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"hello","world","leetcode"}, new String[] {"world","hello"}, true),
                Arguments.of(new String[] {"hello","programming","fun"}, new String[] {"world","programming","leetcode"}, false)
        );
    }

}
