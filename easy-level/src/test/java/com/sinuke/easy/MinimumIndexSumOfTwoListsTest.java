package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MinimumIndexSumOfTwoListsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findRestaurant(String[] list1, String[] list2, String[] expected) {
        var result = new MinimumIndexSumOfTwoLists().findRestaurant(list1, list2);
        Arrays.sort(result);
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"},
                        new String[]{"Shogun"}
                ),
                Arguments.of(
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"KFC", "Shogun", "Burger King"},
                        new String[]{"Shogun"}
                ),
                Arguments.of(
                        new String[]{"happy", "sad", "good"},
                        new String[]{"sad", "happy", "good"},
                        new String[]{"sad", "happy"}
                )
        );
    }

}
