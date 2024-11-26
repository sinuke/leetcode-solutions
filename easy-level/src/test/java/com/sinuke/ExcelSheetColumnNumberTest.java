package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExcelSheetColumnNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void titleToNumber(String input, int expected) {
        var excelSheetColumnNumber = new ExcelSheetColumnNumber();

        assertEquals(expected, excelSheetColumnNumber.titleToNumber(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("A", 1),
                Arguments.of("AB", 28),
                Arguments.of("ZY", 701),
                Arguments.of("FXSHRXW", 2147483647)
        );
    }

}
