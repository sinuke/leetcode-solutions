package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignRideSharingSystemTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rideSharingSystemTest(String[] operations, Object[] values, Object[] expected) {
        DesignRideSharingSystem.RideSharingSystem solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "RideSharingSystem" -> {
                    solution = new DesignRideSharingSystem.RideSharingSystem();
                    actual[i] = null;
                }

                case "addRider" -> {
                    solution.addRider((int) values[i]);
                    actual[i] = null;
                }

                case "addDriver" -> {
                    solution.addDriver((int) values[i]);
                    actual[i] = null;
                }

                case "matchDriverWithRider" -> actual[i] = solution.matchDriverWithRider();

                case "cancelRider" -> {
                    solution.cancelRider((int) values[i]);
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
                        new String[] {"RideSharingSystem", "addRider", "addDriver", "addRider", "matchDriverWithRider", "addDriver", "cancelRider", "matchDriverWithRider", "matchDriverWithRider"},
                        new Object[] {null, 3, 2, 1, null, 5, 3, null, null},
                        new Object[] {null, null, null, null, new int[] {2, 3}, null, null, new int[] {5, 1}, new int[] {-1, -1}}
                ),
                Arguments.of(
                        new String[] {"RideSharingSystem", "addRider", "addDriver", "addDriver", "matchDriverWithRider", "addRider", "cancelRider", "matchDriverWithRider"},
                        new Object[] {null, 8, 8, 6, null, 2, 2, null},
                        new Object[] {null, null, null, null, new int[] {8, 8}, null, null, new int[] {-1, -1}}
                ),
                Arguments.of(
                        new String[] {"RideSharingSystem", "addRider", "addRider", "cancelRider", "addDriver", "cancelRider", "matchDriverWithRider", "matchDriverWithRider"},
                        new Object[] {null, 1, 2, 1, 7, 4, null, null},
                        new Object[] {null, null, null, null, null, null, new int[] {7, 2}, new int[] {-1, -1}}
                )
        );
    }

}
