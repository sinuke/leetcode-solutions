package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisplayTableOfFoodOrdersInRestaurantTest {

    @ParameterizedTest
    @MethodSource("testData")
    void displayTable(List<List<String>> orders, List<List<String>> expected) {
        var solution = new DisplayTableOfFoodOrdersInRestaurant();
        assertEquals(expected, solution.displayTable(orders));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of("David","3","Ceviche"),
                                List.of("Corina","10","Beef Burrito"),
                                List.of("David","3","Fried Chicken"),
                                List.of("Carla","5","Water"),
                                List.of("Carla","5","Ceviche"),
                                List.of("Rous","3","Ceviche")
                        ),
                        List.of(
                                List.of("Table","Beef Burrito","Ceviche","Fried Chicken","Water"),
                                List.of("3","0","2","1","0"),
                                List.of("5","0","1","0","1"),
                                List.of("10","1","0","0","0")
                        )
                ),
                Arguments.of(
                        List.of(
                                List.of("James","12","Fried Chicken"),
                                List.of("Ratesh","12","Fried Chicken"),
                                List.of("Amadeus","12","Fried Chicken"),
                                List.of("Adam","1","Canadian Waffles"),
                                List.of("Brianna","1","Canadian Waffles")
                        ),
                        List.of(
                                List.of("Table","Canadian Waffles","Fried Chicken"),
                                List.of("1","2","0"),
                                List.of("12","0","3")
                        )
                ),
                Arguments.of(
                        List.of(
                                List.of("Laura","2","Bean Burrito"),
                                List.of("Jhon","2","Beef Burrito"),
                                List.of("Melissa","2","Soda")
                        ),
                        List.of(
                                List.of("Table","Bean Burrito","Beef Burrito","Soda"),
                                List.of("2","1","1","1")
                        )
                )
        );
    }

}
