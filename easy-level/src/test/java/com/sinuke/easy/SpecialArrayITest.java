package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialArrayITest {

    @ParameterizedTest
    @MethodSource("testData")
    void isArraySpecial(int[] nums, boolean expected) {
        var specialArray = new SpecialArrayI();
        assertEquals(expected, specialArray.isArraySpecial(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1}, true),
                Arguments.of(new int[] {2,1,4}, true),
                Arguments.of(new int[] {4,3,1,6}, false)
        );
    }

}
