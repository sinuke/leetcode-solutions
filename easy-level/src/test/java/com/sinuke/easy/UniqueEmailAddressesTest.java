package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueEmailAddressesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numUniqueEmails(String[] emails, int expected) {
        var solution = new UniqueEmailAddresses();
        assertEquals(expected, solution.numUniqueEmails(emails));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}, 2),
                Arguments.of(new String[] {"a@leetcode.com","b@leetcode.com","c@leetcode.com"}, 3)
        );
    }

}
