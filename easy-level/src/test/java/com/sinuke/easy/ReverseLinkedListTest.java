package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseList(ListNode head, ListNode expected) {
        var reverseLinkedList = new ReverseLinkedList();
        
        var result = reverseLinkedList.reverseList(head);
        var expectedArray = toArray(expected);
        var resultArray = toArray(result);
        
        assertArrayEquals(expectedArray, resultArray);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void reverseListRecursive(ListNode head, ListNode expected) {
        var reverseLinkedList = new ReverseLinkedList();

        var result = reverseLinkedList.reverseListRecursive(head);
        var expectedArray = toArray(expected);
        var resultArray = toArray(result);

        assertArrayEquals(expectedArray, resultArray);
    }
    
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1, 2, 3, 4, 5), buildList(5, 4, 3, 2, 1)),
                Arguments.of(buildList(1, 2), buildList(2, 1)),
                Arguments.of(buildList(), buildList())
        );
    }
    
}
