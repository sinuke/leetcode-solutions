package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainsDuplicateIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void containsNearbyDuplicate(int[] nums, int k, boolean expected) {
        var containsDuplicateII = new ContainsDuplicateII();
        assertEquals(expected, containsDuplicateII.containsNearbyDuplicate(nums, k));
        assertEquals(expected, containsDuplicateII.containsNearbyDuplicateSlow(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 1}, 3, true),
                Arguments.of(new int[] {1, 0, 1, 1}, 1, true),
                Arguments.of(new int[] {1, 2, 3, 1, 2, 3}, 2, false)
        );
    }

}
