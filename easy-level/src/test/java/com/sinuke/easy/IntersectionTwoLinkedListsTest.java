package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectionTwoLinkedListsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getIntersectionNode(IntersectionTwoLinkedLists.ListNode headA, IntersectionTwoLinkedLists.ListNode headB, IntersectionTwoLinkedLists.ListNode intersection) {
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
    void getIntersectionNodeTwoPointers(IntersectionTwoLinkedLists.ListNode headA, IntersectionTwoLinkedLists.ListNode headB, IntersectionTwoLinkedLists.ListNode intersection) {
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

    private static IntersectionTwoLinkedLists.ListNode createList(int... values) {
        if (values.length == 0) return null;

        var head = new IntersectionTwoLinkedLists.ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new IntersectionTwoLinkedLists.ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

    private static int[] extractValues(IntersectionTwoLinkedLists.ListNode node) {

        int count = 0;
        var first = node;
        while (node != null) {
            count++;
            node = node.next;
        }

        var result = new int[count];
        node = first;
        var index = 0;
        while (node != null) {
            result[index] = node.val;
            node = node.next;
            index++;
        }

        return result;
    }

    private static void addIntersection(IntersectionTwoLinkedLists.ListNode list, IntersectionTwoLinkedLists.ListNode intersection) {
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