package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellsInRangeOnExcelSheetTest {

    @ParameterizedTest
    @MethodSource("testData")
    void cellsInRange(String s, List<String> expected) {
        var solution = new CellsInRangeOnExcelSheet();
        assertEquals(expected, solution.cellsInRange(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("K1:L2", List.of("K1","K2","L1","L2")),
                Arguments.of("A1:F1", List.of("A1","B1","C1","D1","E1","F1"))
        );
    }

}
