package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeightedWordMappingTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mapWordWeights(String[] words, int[] weights, String expected) {
        var solution = new WeightedWordMapping();
        assertEquals(expected, solution.mapWordWeights(words, weights));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"abcd","def","xyz"}, new int[] {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2}, "rij"),
                Arguments.of(new String[] {"a","b","c"}, new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, "yyy"),
                Arguments.of(new String[] {"abcd"}, new int[] {7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5}, "g")
        );
    }

}
