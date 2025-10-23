package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SimpleBankSystemTest {

    @ParameterizedTest
    @MethodSource("testData")
    void bankTest(String[] operations, Object[][] values, Boolean[] expected) {
        SimpleBankSystem.Bank solution = null;
        Boolean[] actual = new Boolean[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Bank" -> {
                    solution = new SimpleBankSystem.Bank(Arrays.stream(values[i]).mapToLong(o -> (Long) o).toArray());
                    actual[i] = null;
                }

                case "deposit" -> actual[i] = solution.deposit((int) values[i][0], (long) values[i][1]);
                case "transfer" -> actual[i] = solution.transfer((int) values[i][0], (int) values[i][1], (long) values[i][2]);
                case "withdraw" -> actual[i] = solution.withdraw((int) values[i][0], (long) values[i][1]);

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"},
                        new Object[][] {
                                {10L, 100L, 20L, 50L, 30L},
                                {3, 10L},
                                {5, 1, 20L},
                                {5, 20L},
                                {3, 4, 15L},
                                {10, 50L}
                        },
                        new Boolean[] {null, true, true, true, false, false}
                )
        );
    }

}
