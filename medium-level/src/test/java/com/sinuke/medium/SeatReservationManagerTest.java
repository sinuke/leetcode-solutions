package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SeatReservationManagerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void seatReservationManager(String[] operations, Integer[] values, Integer[] expected) {
        SeatReservationManager.SeatManager solution = null;
        Integer[] actual = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "SeatManager" -> {
                    solution = new SeatReservationManager.SeatManager(values[i]);
                    actual[i] = null;
                }

                case "reserve" -> actual[i] = solution.reserve();
                case "unreserve" -> {
                    solution.unreserve(values[i]);
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
                        new String[] {"SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"},
                        new Integer[] {5, null, null, 2, null, null, null, null, 5},
                        new Integer[] {null, 1, 2, null, 2, 3, 4, 5, null}
                )
        );
    }

}
