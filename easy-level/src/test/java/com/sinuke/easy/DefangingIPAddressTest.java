package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefangingIPAddressTest {

    @ParameterizedTest
    @MethodSource("testData")
    void defangIPaddr(String address, String expected) {
        var defangingIPAddress = new DefangingIPAddress();
        assertEquals(expected, defangingIPAddress.defangIPaddr(address));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1.1.1.1", "1[.]1[.]1[.]1"),
                Arguments.of("255.100.50.0", "255[.]100[.]50[.]0")
        );
    }

}
