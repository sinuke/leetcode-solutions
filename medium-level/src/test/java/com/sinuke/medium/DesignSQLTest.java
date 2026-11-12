package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignSQLTest {

    @ParameterizedTest
    @MethodSource("testData")
    void designSqlTest(String[] operations, Object[] values, Object[] expected) {
        DesignSQL.SQL solution = null;
        Object[] actual = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "SQL" -> {
                    Object[] vals = (Object[]) values[i];
                    solution = new DesignSQL.SQL((List<String>) vals[0], (List<Integer>) vals[1]);
                    actual[i] = null;
                }

                case "ins" -> {
                    Object[] vals = (Object[]) values[i];
                    actual[i] = solution.ins((String) vals[0], (List<String>) vals[1]);
                }

                case "rmv" -> {
                    Object[] vals = (Object[]) values[i];
                    solution.rmv((String) vals[0], (int) vals[1]);
                    actual[i] = null;
                }

                case "sel" -> {
                    Object[] vals = (Object[]) values[i];
                    actual[i] = solution.sel((String) vals[0], (int) vals[1], (int) vals[2]);
                }

                case "exp" -> actual[i] = solution.exp((String) values[i]);

                default -> throw new IllegalArgumentException("Unknown operation " + operations[i]);
            }
        }

        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[] {"SQL", "ins", "sel", "ins", "exp", "rmv", "sel", "exp"},
                        new Object[] {
                                new Object[] {List.of("one", "two", "three"), List.of(2, 3, 1)},
                                new Object[] {"two", List.of("first", "second", "third")},
                                new Object[] {"two", 1, 3},
                                new Object[] {"two", List.of("fourth", "fifth", "sixth")},
                                "two",
                                new Object[] {"two", 1},
                                new Object[] {"two", 2, 2},
                                "two"
                        },
                        new Object[] {null, true, "third", true, List.of("1,first,second,third", "2,fourth,fifth,sixth"), null, "fifth", List.of("2,fourth,fifth,sixth")}
                ),
                Arguments.of(
                        new String[] {"SQL", "ins", "sel", "rmv", "sel", "ins", "ins"},
                        new Object[] {
                                new Object[] {List.of("one", "two", "three"), List.of(2, 3, 1)},
                                new Object[] {"two", List.of("first", "second", "third")},
                                new Object[] {"two", 1, 3},
                                new Object[] {"two", 1},
                                new Object[] {"two", 1, 2},
                                new Object[] {"two", List.of("fourth", "fifth")},
                                new Object[] {"two", List.of("fourth", "fifth", "sixth")}
                        },
                        new Object[] {null, true, "third", null, "<null>", false, true}
                ),
                Arguments.of(
                        new String[] {"SQL", "ins", "ins", "ins", "rmv", "sel", "exp"},
                        new Object[] {
                                new Object[] {List.of("a"), List.of(2)},
                                new Object[] {"b", List.of("x", "y")},
                                new Object[] {"a", List.of("x")},
                                new Object[] {"a", List.of("x", "y")},
                                new Object[] {"a", 5},
                                new Object[] {"a", 1, 3},
                                "z"
                        },
                        new Object[] {null, false, false, true, null, "<null>", List.of()}
                ),
                Arguments.of(
                        new String[] {"SQL", "ins", "rmv", "ins", "exp"},
                        new Object[] {
                                new Object[] {List.of("a"), List.of(1)},
                                new Object[] {"a", List.of("p")},
                                new Object[] {"a", 1},
                                new Object[] {"a", List.of("q")},
                                "a"
                        },
                        new Object[] {null, true, null, true, List.of("2,q")}
                )
        );
    }

}
