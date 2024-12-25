package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExcelSheetColumnTitleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void convertToTitle(int columnNumber, String expected) {
        var excelSheetColumnTitle = new ExcelSheetColumnTitle();
        
        assertEquals(expected, excelSheetColumnTitle.convertToTitle(columnNumber));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, "A"),
                Arguments.of(25, "Y"),
                Arguments.of(26, "Z"),
                Arguments.of(28, "AB"),
                Arguments.of(701, "ZY"),
                Arguments.of(2147483647, "FXSHRXW")
        );
    }
    
}
