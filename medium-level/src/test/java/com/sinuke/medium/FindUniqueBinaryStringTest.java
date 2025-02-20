package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FindUniqueBinaryStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findDifferentBinaryString(String[] nums, List<String> expected) {
        var solution = new FindUniqueBinaryString();
        var actual = solution.findDifferentBinaryString2(nums);

        assertTrue(expected.contains(actual));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"01","10"}, List.of("00","11")),
                Arguments.of(new String[] {"00","01"}, List.of("11","10")),
                Arguments.of(new String[] {"111","011","001"}, List.of("101", "000", "010", "100", "110")),
                Arguments.of(new String[] {"10","11"}, List.of("00","01"))
        );
    }

}
