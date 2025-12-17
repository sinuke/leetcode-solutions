package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfDifferentIntegersInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numDifferentIntegers(String word, int expected) {
        var solution = new NumberOfDifferentIntegersInString();
        assertEquals(expected, solution.numDifferentIntegers(word));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("a123bc34d8ef34", 3),
                Arguments.of("leet1234code234", 2),
                Arguments.of("a1b01c001", 1),
                Arguments.of("167278959591294", 1),
                Arguments.of("2393706880236110407059624696967828762752651982730115221690437821508229419410771541532394006597463715513741725852432559057224478815116557380260390432211227579663571046845842281704281749571110076974264971989893607137140456254346955633455446057823738757323149856858154529105301197388177242583658641529908583934918768953462557716z97438020429952944646288084173334701047574188936201324845149110176716130267041674438237608038734431519439828191344238609567530399189316846359766256507371240530620697102864238792350289978450509162697068948604722646739174590530336510475061521094503850598453536706982695212493902968251702853203929616930291257062173c79487281900662343830648295410", 3),
                Arguments.of("0a0", 1),
                Arguments.of("0v050vfy", 2)
        );
    }

}
