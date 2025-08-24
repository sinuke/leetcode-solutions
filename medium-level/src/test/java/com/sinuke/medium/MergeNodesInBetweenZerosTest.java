package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeNodesInBetweenZerosTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeNodes(ListNode head, ListNode expected) {
        var solution =  new MergeNodesInBetweenZeros();
        assertArrayEquals(toArray(expected), toArray(solution.mergeNodes(head)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(0,3,1,0,4,5,2,0), buildList(4,11)),
                Arguments.of(buildList(0,1,0,3,0,2,2,0), buildList(1,3,4))
        );
    }

}
