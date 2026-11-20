package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignImplementRouterTest {

    @ParameterizedTest
    @MethodSource("testData")
    void implementRouterTest(String[] operations, Object[] values, Object[] expected) {
        DesignImplementRouter.Router solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Router" -> {
                    solution = new DesignImplementRouter.Router((int) values[i]);
                    actual[i] = null;
                }

                case "addPacket" -> {
                    int[] vals = (int[]) values[i];
                    actual[i] = solution.addPacket(vals[0], vals[1], vals[2]);
                }

                case "forwardPacket" -> actual[i] = solution.forwardPacket();

                case "getCount" -> {
                    int[] vals = (int[]) values[i];
                    actual[i] = solution.getCount(vals[0], vals[1], vals[2]);
                }

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"Router", "addPacket", "addPacket", "addPacket", "addPacket", "addPacket", "forwardPacket", "addPacket", "getCount"},
                        new Object[] {
                                3,
                                new int[] {1, 4, 90},
                                new int[] {2, 5, 90},
                                new int[] {1, 4, 90},
                                new int[] {3, 5, 95},
                                new int[] {4, 5, 105},
                                null,
                                new int[] {5, 2, 110},
                                new int[] {5, 100, 110}
                        },
                        new Object[] {null, true, true, false, true, true, new int[] {2, 5, 90}, true, 1}
                ),
                Arguments.of(
                        new String[] {"Router", "addPacket", "forwardPacket", "forwardPacket"},
                        new Object[] {
                                2,
                                new int[] {7, 4, 90},
                                null,
                                null
                        },
                        new Object[] {null, true, new int[] {7, 4, 90}, new int[] {}}
                ),
                Arguments.of(
                        new String[] {"Router", "addPacket", "addPacket", "addPacket", "getCount", "forwardPacket", "getCount", "addPacket", "getCount"},
                        new Object[] {
                                2,
                                new int[] {1, 2, 10},
                                new int[] {3, 2, 20},
                                new int[] {4, 2, 30},
                                new int[] {2, 1, 30},
                                null,
                                new int[] {2, 10, 30},
                                new int[] {4, 2, 30},
                                new int[] {2, 30, 30}
                        },
                        new Object[] {null, true, true, true, 2, new int[] {3, 2, 20}, 1, false, 1}
                )
        );
    }

}
