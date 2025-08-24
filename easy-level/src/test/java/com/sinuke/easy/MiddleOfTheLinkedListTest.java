package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MiddleOfTheLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void middleNode(ListNode head, ListNode expected) {
        var solution = new MiddleOfTheLinkedList();
        var expectedArray = toArray(expected);
        var actualArray = toArray(solution.middleNode(head));

        assertArrayEquals(expectedArray, actualArray);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1,2,3,4,5), buildList(3,4,5)),
                Arguments.of(buildList(1,2,3,4,5,6), buildList(4,5,6)),
                Arguments.of(buildList(1), buildList(1))
        );
    }

}
