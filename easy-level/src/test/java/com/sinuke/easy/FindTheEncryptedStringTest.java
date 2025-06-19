package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheEncryptedStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getEncryptedString(String s, int k, String expected) {
        var solution = new FindTheEncryptedString();
        assertEquals(expected, solution.getEncryptedString(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("dart", 3, "tdar"),
                Arguments.of("aaa", 1, "aaa"),
                Arguments.of("byd", 4, "ydb")
        );
    }

}
