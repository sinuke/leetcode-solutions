package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignParkingSystemTest {

    @ParameterizedTest
    @MethodSource("testData")
    void parkingSystemTest(String[] operations, int[][] values, Object[] expected) {
        DesignParkingSystem.ParkingSystem parkingSystem = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "ParkingSystem" -> {
                    parkingSystem = new DesignParkingSystem.ParkingSystem(values[i][0], values[i][1], values[i][2]);
                    actual[i] = null;
                }

                case "addCar" -> actual[i] = parkingSystem.addCar(values[i][0]);

                default -> throw new IllegalArgumentException("Unknown operation: " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"ParkingSystem", "addCar", "addCar", "addCar", "addCar"},
                        new int[][] {{1, 1, 0}, {1}, {2}, {3}, {1}},
                        new Object[] {null, true, true, false, false}
                )
        );
    }

}
