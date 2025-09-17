package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignFoodRatingSystemTest {

    @ParameterizedTest
    @MethodSource("testData")
    void foodRatingSystemTest(String[] operations, Object[] values, String[] expected) {
        DesignFoodRatingSystem.FoodRatings solution = null;
        String[] actual = new String[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "FoodRatings" -> {
                    Object[] vals = (Object[]) values[i];
                    solution = new DesignFoodRatingSystem.FoodRatings((String[]) vals[0], (String[]) vals[1], (int[]) vals[2]);
                    actual[i] = null;
                }

                case "highestRated" -> actual[i] = solution.highestRated((String) values[i]);

                case "changeRating" -> {
                    Object[] vals = (Object[]) values[i];
                    solution.changeRating((String) vals[0], (int) vals[1]);
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
                        new String[] {"FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"},
                        new Object[] {
                                new Object[] {
                                        new String[] {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                                        new String[] {"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                                        new int[] {9, 12, 8, 15, 14, 7}
                                },
                                "korean",
                                "japanese",
                                new Object[] {"sushi", 16},
                                "japanese",
                                new Object[] {"ramen", 16},
                                "japanese"
                        },
                        new String[] {null, "kimchi", "ramen", null, "sushi", null, "ramen"}
                ),
                Arguments.of(
                        new String[] {"FoodRatings","changeRating","highestRated","changeRating","changeRating","changeRating","highestRated","highestRated"},
                        new Object[] {
                                new Object[] {
                                        new String[] {"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"},
                                        new String[] {"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"},
                                        new int[] {2,6,18,6,5}
                                },
                                new Object[] {"qnvseohnoe",11},
                                "fajbervsj",
                                new Object[] {"emgqdbo",3},
                                new Object[] {"jmvfxjohq",9},
                                new Object[] {"emgqdbo",14},
                                "fajbervsj",
                                "snaxol"
                        },
                        new String[] {null,null,"yhptazyko",null,null,null,"yhptazyko","emgqdbo"}
                ),
                Arguments.of(
                        new String[] {"FoodRatings","changeRating","highestRated","changeRating","changeRating","highestRated"},
                        new Object[] {
                                new Object[] {
                                        new String[] {"czopaaeyl","lxoozsbh","kbaxapl"},
                                        new String[] {"dmnuqeatj","dmnuqeatj","dmnuqeatj"},
                                        new int[] {11,2,15}
                                },
                                new Object[] {"czopaaeyl",12},
                                "dmnuqeatj",
                                new Object[] {"kbaxapl",8},
                                new Object[] {"lxoozsbh",5},
                                "dmnuqeatj"
                        },
                        new String[] {null,null,"kbaxapl",null,null,"czopaaeyl"}
                )
        );
    }

}
