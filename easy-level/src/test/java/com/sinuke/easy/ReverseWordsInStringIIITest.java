package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsInStringIIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseWords(String s, String expected) {
        var reverse = new ReverseWordsInStringIII();
        assertEquals(expected, reverse.reverseWords(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"),
                Arguments.of("Mr Ding", "rM gniD"),
                Arguments.of("Word", "droW")
        );
    }

}
