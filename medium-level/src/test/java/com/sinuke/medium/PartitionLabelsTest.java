package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartitionLabelsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void partitionLabels(String s, List<Integer> expected) {
        var solution = new PartitionLabels();
        assertEquals(expected, solution.partitionLabels(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ababcbacadefegdehijhklij", List.of(9, 7, 8)),
                Arguments.of("eccbbbbdec", List.of(10)),
                Arguments.of("e", List.of(1)),
                Arguments.of("qiejxqfnqceocmy", List.of(13,1,1))
        );
    }

}
