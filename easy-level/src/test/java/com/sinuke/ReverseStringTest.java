package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseString(char[] s, char[] expected) {
        var reverseString = new ReverseString();
        reverseString.reverseString(s);
        assertArrayEquals(expected, s);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new char[] {'h','e','l','l','o'}, new char[] {'o','l','l','e','h'}),
                Arguments.of(new char[] {'H','a','n','n','a','h'}, new char[] {'h','a','n','n','a','H'})
        );
    }

}
