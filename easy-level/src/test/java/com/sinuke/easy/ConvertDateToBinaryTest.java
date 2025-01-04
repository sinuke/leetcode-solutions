package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertDateToBinaryTest {

    @ParameterizedTest
    @MethodSource("testData")
    void convertDateToBinary(String date, String expected) {
        var converter = new ConvertDateToBinary();
        assertEquals(expected, converter.convertDateToBinary(date));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("2080-02-29", "100000100000-10-11101"),
                Arguments.of("1900-01-01", "11101101100-1-1")
        );
    }

}
