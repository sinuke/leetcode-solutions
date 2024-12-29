package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindAllNumbersDisappearedInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findDisappearedNumbers(int[] nums, List<Integer> expected) {
        var findAllNumbersDisappeared = new FindAllNumbersDisappearedInArray();

        assertEquals(expected, findAllNumbersDisappeared.findDisappearedNumbers(Arrays.copyOf(nums, nums.length)));
//        assertEquals(expected, findAllNumbersDisappeared.findDisappearedNumbers2(Arrays.copyOf(nums, nums.length)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,3,2,7,8,2,3,1}, List.of(5, 6)),
                Arguments.of(new int[] {1, 1}, List.of(2)),
                Arguments.of(new int[] {2, 2}, List.of(1)),
                Arguments.of(new int[] {5,4,6,7,9,3,10,9,5,6}, List.of(1,2,8))
        );
    }

}
