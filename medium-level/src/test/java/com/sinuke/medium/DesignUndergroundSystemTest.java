package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DesignUndergroundSystemTest {

    @ParameterizedTest
    @MethodSource("testData")
    void undergroundSystemTest(String[] operations, Object[] values, Double[] expected) {
        DesignUndergroundSystem.UndergroundSystem solution = null;
        Double[] actual = new Double[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "UndergroundSystem" -> {
                    solution = new DesignUndergroundSystem.UndergroundSystem();
                    actual[i] = null;
                }

                case "checkIn" -> {
                    Object[] vals = (Object[]) values[i];
                    solution.checkIn((int) vals[0], (String) vals[1], (int) vals[2]);
                    actual[i] = null;
                }

                case "checkOut" -> {
                    Object[] vals = (Object[]) values[i];
                    solution.checkOut((int) vals[0], (String) vals[1], (int) vals[2]);
                    actual[i] = null;
                }

                case "getAverageTime" -> {
                    String[] vals = (String[]) values[i];
                    actual[i] = solution.getAverageTime(vals[0], vals[1]);
                }

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < operations.length; i++) {
            if (expected[i] != null) assertEquals(expected[i], actual[i], 0.00001);
            else assertNull(actual[i]);
        }
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"},
                        new Object[] {
                                null,
                                new Object[] {45,"Leyton",3},
                                new Object[] {32,"Paradise",8},
                                new Object[] {27,"Leyton",10},
                                new Object[] {45,"Waterloo",15},
                                new Object[] {27,"Waterloo",20},
                                new Object[] {32,"Cambridge",22},
                                new String[] {"Paradise","Cambridge"},
                                new String[] {"Leyton","Waterloo"},
                                new Object[] {10,"Leyton",24},
                                new String[] {"Leyton","Waterloo"},
                                new Object[] {10,"Waterloo",38},
                                new String[] {"Leyton","Waterloo"}
                        },
                        new Double[] {null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000}
                ),
                Arguments.of(
                        new String[] {"UndergroundSystem","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime","checkIn","checkOut","getAverageTime"},
                        new Object[] {
                                null,
                                new Object[] {10,"Leyton",3},
                                new Object[] {10,"Paradise",8},
                                new String[] {"Leyton","Paradise"},
                                new Object[] {5,"Leyton",10},
                                new Object[] {5,"Paradise",16},
                                new String[] {"Leyton","Paradise"},
                                new Object[] {2,"Leyton",21},
                                new Object[] {2,"Paradise",30},
                                new String[] {"Leyton","Paradise"}
                        },
                        new Double[] {null,null,null,5.00000,null,null,5.50000,null,null,6.66667}
                )
        );
    }

}
