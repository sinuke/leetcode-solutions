package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignBitsetTest {

    @ParameterizedTest
    @MethodSource("testData")
    void designBitsetTest(String[] operations, Integer[] values, Object[] expected) {
        DesignBitset.Bitset solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Bitset" -> {
                    solution = new DesignBitset.Bitset(values[i]);
                    actual[i] = null;
                }

                case "fix" -> {
                    solution.fix(values[i]);
                    actual[i] = null;
                }

                case "unfix" -> {
                    solution.unfix(values[i]);
                    actual[i] = null;
                }

                case "flip" -> {
                    solution.flip();
                    actual[i] = null;
                }

                case "all" -> actual[i] = solution.all();
                case "one" -> actual[i] = solution.one();
                case "count" -> actual[i] = solution.count();
                case "toString" -> actual[i] = solution.toString();

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"Bitset", "fix", "fix", "flip", "all", "unfix", "flip", "one", "unfix", "count", "toString"},
                        new Integer[] {5, 3, 1, null, null, 0, null, null, 0, null, null},
                        new Object[] {null, null, null, null, false, null, null, true, null, 2, "01010"}
                )
        );
    }

}
