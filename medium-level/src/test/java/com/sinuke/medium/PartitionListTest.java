package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PartitionListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void partition(ListNode head, int x, ListNode expected) {
        var solution = new PartitionList();
        assertArrayEquals(toArray(expected), toArray(solution.partition(head, x)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1, 4, 3, 2, 5, 2), 3, buildList(1, 2, 2, 4, 3, 5)),
                Arguments.of(buildList(2, 1), 2, buildList(1, 2))
        );
    }

}
