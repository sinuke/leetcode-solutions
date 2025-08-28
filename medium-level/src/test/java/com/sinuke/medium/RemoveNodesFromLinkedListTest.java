package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoveNodesFromLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeNodes(ListNode head, ListNode expected) {
        var solution = new RemoveNodesFromLinkedList();
        assertArrayEquals(toArray(expected), toArray(solution.removeNodes(head)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(5,2,13,3,8), buildList(13,8)),
                Arguments.of(buildList(1,1,1,1), buildList(1,1,1,1))
        );
    }

}
