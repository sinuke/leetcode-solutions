package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignSpreadsheetTest {

    @ParameterizedTest
    @MethodSource("testData")
    void spreadsheetTest(String[] operations, Object[] values, Integer[] expected) {
        DesignSpreadsheet.Spreadsheet solution = null;
        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Spreadsheet" -> {
                    solution = new DesignSpreadsheet.Spreadsheet((int) values[i]);
                    actual[i] = null;
                }

                case "getValue" -> actual[i] = solution.getValue((String) values[i]);

                case "setCell" -> {
                    Object[] vals = (Object[]) values[i];
                    solution.setCell((String) vals[0], (int) vals[1]);
                    actual[i] = null;
                }

                case "resetCell" -> {
                    solution.resetCell((String) values[i]);
                    actual[i] = null;
                }

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue"},
                        new Object[] {
                                3,
                                "=5+7",
                                new Object[] {"A1", 10},
                                "=A1+6",
                                new Object[] {"B2", 15},
                                "=A1+B2",
                                "A1",
                                "=A1+B2"
                        },
                        new Integer[] {null, 12, null, 16, null, 25, null, 15}
                )
        );
    }

}
