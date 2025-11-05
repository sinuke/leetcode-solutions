package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CouponCodeValidatorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void validateCoupons(String[] code, String[] businessLine, boolean[] isActive, List<String> expected) {
        var solution = new CouponCodeValidator();
        assertEquals(expected, solution.validateCoupons(code, businessLine, isActive));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"SAVE20","","PHARMA5","SAVE@20"}, new String[] {"restaurant","grocery","pharmacy","restaurant"}, new boolean[] {true,true,true,true}, List.of("PHARMA5","SAVE20")),
                Arguments.of(new String[] {"GROCERY15","ELECTRONICS_50","DISCOUNT10"}, new String[] {"grocery","electronics","invalid"}, new boolean[] {false,true,true}, List.of("ELECTRONICS_50"))
        );
    }

}
