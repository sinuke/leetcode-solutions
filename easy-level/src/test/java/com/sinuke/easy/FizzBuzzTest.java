package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @ParameterizedTest
    @MethodSource("testData")
    void fizzBuzz(int n, List<String> expected) {
        var fozBuzz = new FizzBuzz();
        assertEquals(expected, fozBuzz.fizzBuzz(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, Arrays.asList("1", "2", "Fizz")),
                Arguments.of(5, Arrays.asList("1", "2", "Fizz", "4", "Buzz")),
                Arguments.of(15, Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"))
        );
    }

}
