package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.createList;
import static com.sinuke.common.data.ListNode.extractValues;
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
        int[] intersectionArray = extractValues(intersection);
        int[] resultArray = extractValues(result);

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
        int[] intersectionArray = extractValues(intersection);
        int[] resultArray = extractValues(result);

        // then
        assertArrayEquals(intersectionArray, resultArray);
    }
    
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(4, 1), createList(5, 6, 1), createList(8, 4, 5)),
                Arguments.of(createList(1, 9, 1), createList(3), createList(2, 4)),
                Arguments.of(createList(2, 6, 4), createList(1, 5), createList())
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