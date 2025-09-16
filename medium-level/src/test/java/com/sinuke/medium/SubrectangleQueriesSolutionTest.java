package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SubrectangleQueriesSolutionTest {

    @ParameterizedTest
    @MethodSource("testData")
    public void subrectangleQueriesSolution(String[] operations, Object[] values, Integer[] expected) {
        SubrectangleQueriesSolution.SubrectangleQueries solution = null;
        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "SubrectangleQueries" -> {
                    solution = new SubrectangleQueriesSolution.SubrectangleQueries((int[][])  values[i]);
                    actual[i] = null;
                }

                case "updateSubrectangle" -> {
                    int[] val = (int[])  values[i];
                    solution.updateSubrectangle(val[0], val[1], val[2], val[3], val[4]);
                    actual[i] = null;
                }

                case "getValue" -> {
                    int[] val = (int[])  values[i];
                    actual[i] = solution.getValue(val[0], val[1]);
                }

                default -> throw new IllegalStateException("Unsupported operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"},
                        new Object[] {
                                new int[][] {{1,2,1},{4,3,4},{3,2,1},{1,1,1}},
                                new int[] {0,2},
                                new int[] {0,0,3,2,5},
                                new int[] {0,2},
                                new int[] {3,1},
                                new int[] {3,0,3,2,10},
                                new int[] {3,1},
                                new int[] {0,2}
                        },
                        new Integer[] {null,1,null,5,5,null,10,5}
                )
        );
    }

}
