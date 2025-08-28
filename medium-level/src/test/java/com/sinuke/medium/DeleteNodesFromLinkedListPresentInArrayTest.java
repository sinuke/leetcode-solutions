package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DeleteNodesFromLinkedListPresentInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void modifiedList(int[] nums, ListNode head, ListNode expected) {
        var solution = new DeleteNodesFromLinkedListPresentInArray();
        assertArrayEquals(toArray(expected), toArray(solution.modifiedList(nums, head)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3}, buildList(1,2,3,4,5), buildList(4,5)),
                Arguments.of(new int[] {1}, buildList(1,2,1,2,1,2), buildList(2,2,2)),
                Arguments.of(new int[] {5}, buildList(1,2,3,4), buildList(1,2,3,4))
        );
    }

}
