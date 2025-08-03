package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LicenseKeyFormattingTest {

    @ParameterizedTest
    @MethodSource("testData")
    void licenseKeyFormatting(String s, int k, String expected) {
        var solution = new LicenseKeyFormatting();
        assertEquals(expected, solution.licenseKeyFormatting(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("5F3Z-2e-9-w", 4, "5F3Z-2E9W"),
                Arguments.of("2-5g-3-J", 2, "2-5G-3J")
        );
    }

}
