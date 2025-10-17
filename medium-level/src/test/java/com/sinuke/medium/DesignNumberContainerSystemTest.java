package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignNumberContainerSystemTest {

    @ParameterizedTest
    @MethodSource("testData")
    void designNumberContainerSystemTest(String[] operations, Integer[][] values, Integer[] expected) {
        DesignNumberContainerSystem.NumberContainers solution = null;
        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch(operations[i]) {
                case "NumberContainers" -> {
                    solution = new DesignNumberContainerSystem.NumberContainers();
                    actual[i] = null;
                }

                case "find" -> actual[i] = solution.find(values[i][0]);
                case "change" -> {
                    solution.change(values[i][0], values[i][1]);
                    actual[i] = null;
                }

                default -> throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"NumberContainers","find","change","change","change","change","find","change","find"},
                        new Integer[][] {{},{10},{2,10},{1,10},{3,10},{5,10},{10},{1,20},{10}},
                        new Integer[] {null,-1,null,null,null,null,1,null,2}
                ),
                Arguments.of(
                        new String[] {"NumberContainers","change","find","change","find","find","find"},
                        new Integer[][] {{},{1,10},{10},{1,20},{10},{20},{30}},
                        new Integer[] {null,null,1,null,-1,1,-1}
                )
        );
    }

}
