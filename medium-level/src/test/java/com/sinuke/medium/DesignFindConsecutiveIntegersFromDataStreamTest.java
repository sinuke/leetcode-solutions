package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignFindConsecutiveIntegersFromDataStreamTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findConsecutiveIntegersFromDataStreamTest(String[] operations, Object[] values, Object[] expected) {
        DesignFindConsecutiveIntegersFromDataStream.DataStream solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "DataStream" -> {
                    int[] vals = (int[]) values[i];
                    solution = new DesignFindConsecutiveIntegersFromDataStream.DataStream(vals[0], vals[1]);
                    actual[i] = null;
                }

                case "consec" -> actual[i] = solution.consec((int) values[i]);

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"DataStream", "consec", "consec", "consec", "consec"},
                        new Object[] {new int[] {4, 3}, 4, 4, 4, 3},
                        new Object[] {null, false, false, true, false}
                ),
                Arguments.of(
                        new String[] {"DataStream", "consec", "consec", "consec", "consec", "consec"},
                        new Object[] {new int[] {5, 2}, 5, 5, 6, 5, 5},
                        new Object[] {null, false, true, false, false, true}
                ),
                Arguments.of(
                        new String[] {"DataStream", "consec", "consec", "consec"},
                        new Object[] {new int[] {10, 1}, 10, 7, 10},
                        new Object[] {null, true, false, true}
                )
        );
    }

}
