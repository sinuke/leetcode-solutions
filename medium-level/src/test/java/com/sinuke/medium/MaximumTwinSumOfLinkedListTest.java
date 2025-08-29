package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumTwinSumOfLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void pairSum(ListNode head, int expected) {
        var solution = new MaximumTwinSumOfLinkedList();
        assertEquals(expected, solution.pairSum(head));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(5,4,2,1), 6),
                Arguments.of(buildList(4,2,2,3), 7),
                Arguments.of(buildList(1,100000), 100001)
        );
    }

}
