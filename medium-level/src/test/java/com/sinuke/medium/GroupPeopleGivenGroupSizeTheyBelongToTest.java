package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupPeopleGivenGroupSizeTheyBelongToTest {

    @ParameterizedTest
    @MethodSource("testData")
    void groupThePeople(int[] groupSizes, List<List<Integer>> expected) {
        expected.forEach(l -> l.sort(Comparator.naturalOrder()));
        expected.sort(Comparator.comparingInt(List::getFirst));

        var actual = new GroupPeopleGivenGroupSizeTheyBelongTo().groupThePeople(groupSizes);
        actual.forEach(l -> l.sort(Comparator.naturalOrder()));
        actual.sort(Comparator.comparingInt(List::getFirst));

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{3, 3, 3, 3, 3, 1, 3},
                        new ArrayList<>(List.of(
                                new ArrayList<>(List.of(5)),
                                new ArrayList<>(List.of(0, 1, 2)),
                                new ArrayList<>(List.of(3, 4, 6))
                        ))
                ),
                Arguments.of(
                        new int[]{2, 1, 3, 3, 3, 2},
                        new ArrayList<>(List.of(
                                new ArrayList<>(List.of(1)),
                                new ArrayList<>(List.of(0, 5)),
                                new ArrayList<>(List.of(2, 3, 4))
                        ))
                )
        );
    }

}
