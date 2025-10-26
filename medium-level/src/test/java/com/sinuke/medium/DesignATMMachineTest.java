package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignATMMachineTest {

    @ParameterizedTest
    @MethodSource("testData")
    void designATMMachine(String[] operations, int[][] values, Object[] expected) {
        DesignATMMachine.ATM solution = null;
        Object[] actual = new Object[values.length];

        for (int i = 0; i < values.length; i++) {
            switch (operations[i]) {
                case "ATM" -> {
                    solution = new DesignATMMachine.ATM();
                    actual[i] = null;
                }

                case "deposit" -> {
                    solution.deposit(values[i]);
                    actual[i] = null;
                }

                case "withdraw" -> actual[i] = solution.withdraw(values[i][0]);

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"ATM", "deposit", "withdraw", "deposit", "withdraw", "withdraw"},
                        new int[][]{{}, {0,0,1,2,1}, {600}, {0,1,0,1,1}, {600}, {550}},
                        new Object[] {null, null, new int[] {0,0,1,0,1}, null, new int[] {-1}, new int[] {0,1,0,0,1}}
                )
        );
    }

}
