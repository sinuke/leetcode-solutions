package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityFrequencyCharactersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void majorityFrequencyGroup(String s, String expected) {
        var solution = new MajorityFrequencyCharacters();
        assertEquals(
                expected.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()),
                solution.majorityFrequencyGroup(s).chars().mapToObj(c -> (char) c).collect(Collectors.toSet())
        );
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aaabbbccdddde", "ab"),
                Arguments.of("abcd", "abcd"),
                Arguments.of("pfpfgi", "fp")
        );
    }

}
