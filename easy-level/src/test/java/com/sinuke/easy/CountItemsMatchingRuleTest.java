package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountItemsMatchingRuleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countMatches(List<List<String>> items, String ruleKey, String ruleValue, int expected) {
        var counter = new CountItemsMatchingRule();
        assertEquals(expected, counter.countMatches(items, ruleKey, ruleValue));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(
                        List.of("phone","blue","pixel"),
                        List.of("computer","silver","lenovo")),
                        "color", "silver", 1),
                Arguments.of(List.of(
                        List.of("phone","blue","pixel"),
                        List.of("computer","silver","phone"),
                        List.of("phone","gold","iphone")),
                        "type", "phone", 2)
        );
    }

}
