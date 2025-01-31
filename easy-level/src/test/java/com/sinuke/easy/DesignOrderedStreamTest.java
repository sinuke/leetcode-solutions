package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignOrderedStreamTest {


    @ParameterizedTest
    @MethodSource("testData")
    void orderedStreamTest(String[] operations, Object[][] values, Object[] expected) {
        DesignOrderedStream.OrderedStream orderedStream = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "OrderedStream": {
                    orderedStream = new DesignOrderedStream.OrderedStream((int) values[i][0]);
                    actual[i] = null;
                    break;
                }

                case "insert": {
                    actual[i] = orderedStream.insert((int) values[i][0], (String) values[i][1]);
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
                        new String[] {"OrderedStream", "insert", "insert", "insert", "insert", "insert"},
                        new Object[][] {{5}, {3, "ccccc"}, {1, "aaaaa"}, {2, "bbbbb"}, {5, "eeeee"}, {4, "ddddd"}},
                        new Object[] {null, List.of(), List.of("aaaaa"), List.of("bbbbb", "ccccc"), List.of(), List.of("ddddd", "eeeee")}
                )
        );
    }

}
