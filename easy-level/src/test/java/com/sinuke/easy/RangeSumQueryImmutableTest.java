package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RangeSumQueryImmutableTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rangeSumQueryImmutableTest(String[] operations, int[][] values, Object[] expected) {
        RangeSumQueryImmutable.NumArray numArray = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "NumArray": {
                    numArray = new RangeSumQueryImmutable.NumArray(values[i]);
                    actual[i] = null;
                    break;
                }

                case "sumRange": {
                    actual[i] = numArray.sumRange(values[i][0], values[i][1]);
                    break;
                }

                default: throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"NumArray", "sumRange", "sumRange", "sumRange"},
                        new int[][] {{-2, 0, 3, -5, 2, -1}, {0, 2}, {2, 5}, {0, 5}},
                        new Object[] {null, 1, -1, -3}
                )
        );
    }

}