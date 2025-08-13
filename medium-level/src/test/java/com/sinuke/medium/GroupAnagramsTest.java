package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void groupAnagrams(String[] strs, List<List<String>> expected) {
        var solution = new GroupAnagrams();

        expected.forEach(l -> l.sort(Comparator.naturalOrder()));
        expected.sort(Comparator.comparingInt(List::size));

        var actual1 = solution.groupAnagrams(strs);
        actual1.forEach(l -> l.sort(Comparator.naturalOrder()));
        actual1.sort(Comparator.comparingInt(List::size));
        assertEquals(expected, actual1);

        var actual2 = solution.groupAnagrams2(strs);
        actual2.forEach(l -> l.sort(Comparator.naturalOrder()));
        actual2.sort(Comparator.comparingInt(List::size));
        assertEquals(expected, actual2);

        var actual3 = solution.groupAnagrams3(strs);
        actual3.forEach(l -> l.sort(Comparator.naturalOrder()));
        actual3.sort(Comparator.comparingInt(List::size));
        assertEquals(expected, actual3);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"eat","tea","tan","ate","nat","bat"}, new ArrayList<>(List.of(new ArrayList<>(List.of("bat")), new ArrayList<>(List.of("nat","tan")), new ArrayList<>(List.of("ate","eat","tea"))))),
                Arguments.of(new String[] {""}, new ArrayList<>(List.of(new ArrayList(List.of(""))))),
                Arguments.of(new String[] {"a"}, new ArrayList<>(List.of(new ArrayList(List.of("a")))))
        );
    }

}
