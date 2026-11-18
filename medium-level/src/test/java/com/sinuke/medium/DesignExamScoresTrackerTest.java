package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignExamScoresTrackerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void designExamScoresTrackerTest(String[] operations, Object[] values, Object[] expected) {
        DesignExamScoresTracker.ExamTracker solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "ExamTracker" -> {
                    solution = new DesignExamScoresTracker.ExamTracker();
                    actual[i] = null;
                }

                case "record" -> {
                    int[] vals = (int[]) values[i];
                    solution.record(vals[0], vals[1]);
                    actual[i] = null;
                }

                case "totalScore" -> {
                    int[] vals = (int[]) values[i];
                    actual[i] = solution.totalScore(vals[0], vals[1]);
                }

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"ExamTracker", "record", "totalScore", "record", "totalScore", "totalScore", "totalScore", "totalScore"},
                        new Object[] {
                                new int[] {},
                                new int[] {1, 98},
                                new int[] {1, 1},
                                new int[] {5, 99},
                                new int[] {1, 3},
                                new int[] {1, 5},
                                new int[] {3, 4},
                                new int[] {2, 5}
                        },
                        new Object[] {null, null, 98L, null, 98L, 197L, 0L, 99L}
                ),
                Arguments.of(
                        new String[] {"ExamTracker", "record", "record", "totalScore", "totalScore"},
                        new Object[] {
                                new int[] {},
                                new int[] {1, 5},
                                new int[] {3, 7},
                                new int[] {1, 3},
                                new int[] {2, 2}
                        },
                        new Object[] {null, null, null, 12L, 0L}
                )
        );
    }

}
