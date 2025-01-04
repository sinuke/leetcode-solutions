package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JewelsAndStonesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numJewelsInStones(String jewels, String stones, int expected) {
        var jewelsAndStones = new JewelsAndStones();
        assertEquals(expected, jewelsAndStones.numJewelsInStones(jewels, stones));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aA", "aAAbbbb", 3),
                Arguments.of("z", "ZZ", 0)
        );
    }

}