package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DeleteNodeInLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void deleteNode(ListNode head, ListNode node, int[] expected) {
        var solution = new DeleteNodeInLinkedList();
        solution.deleteNode(node);
        assertArrayEquals(expected, toArray(head));
    }

    private static Stream<Arguments> testData() {
        var head1 = buildList(4,5,1,9);
        var head2 = buildList(4,5,1,9);

        return Stream.of(
                Arguments.of(head1, head1.next, new int[] {4, 1, 9}),
                Arguments.of(head2, head2.next.next, new int[] {4, 5, 9})
        );
    }

}
