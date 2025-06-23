package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoatLatinTest {

    @ParameterizedTest
    @MethodSource("testData")
    void toGoatLatin(String sentence, String expected) {
        var solution = new GoatLatin();
        assertEquals(expected, solution.toGoatLatin(sentence));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("I speak Goat Latin", "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"),
                Arguments.of("The quick brown fox jumped over the lazy dog", "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"),
                Arguments.of("Each word consists of lowercase and uppercase letters only", "Eachmaa ordwmaaa onsistscmaaaa ofmaaaaa owercaselmaaaaaa andmaaaaaaa uppercasemaaaaaaaa etterslmaaaaaaaaa onlymaaaaaaaaaa")
        );
    }

}
