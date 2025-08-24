package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectionTwoLinkedListsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getIntersectionNode(ListNode headA, ListNode headB, ListNode intersection) {
        // given
        var intersectionTwoLinkedLists = new IntersectionTwoLinkedLists();
        if (intersection != null) {
            addIntersection(headA, intersection);
            addIntersection(headB, intersection);
        }

        // when
        var result = intersectionTwoLinkedLists.getIntersectionNode(headA, headB);
        int[] intersectionArray = toArray(intersection);
        int[] resultArray = toArray(result);

        // then
        assertArrayEquals(intersectionArray, resultArray);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void getIntersectionNodeTwoPointers(ListNode headA, ListNode headB, ListNode intersection) {
        // given
        var intersectionTwoLinkedLists = new IntersectionTwoLinkedLists();
        if (intersection != null) {
            addIntersection(headA, intersection);
            addIntersection(headB, intersection);
        }

        // when
        var result = intersectionTwoLinkedLists.getIntersectionNodeTwoPointers(headA, headB);
        int[] intersectionArray = toArray(intersection);
        int[] resultArray = toArray(result);

        // then
        assertArrayEquals(intersectionArray, resultArray);
    }
    
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(4, 1), buildList(5, 6, 1), buildList(8, 4, 5)),
                Arguments.of(buildList(1, 9, 1), buildList(3), buildList(2, 4)),
                Arguments.of(buildList(2, 6, 4), buildList(1, 5), buildList())
        );
    }

    private static void addIntersection(ListNode list, ListNode intersection) {
        var current = list;
        while (current != null) {
            if (current.next == null) {
                current.next = intersection;
                break;
            }
            current = current.next;
        }
    }
    
}