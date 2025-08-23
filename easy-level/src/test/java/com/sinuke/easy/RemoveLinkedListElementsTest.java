package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.createList;
import static com.sinuke.common.data.ListNode.extractValues;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoveLinkedListElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeElements(ListNode head, int val, int[] expected) {
        var removeLinkedListElements = new RemoveLinkedListElements();

        var result = removeLinkedListElements.removeElements(head, val);
        int[] resultArray = extractValues(result);

        assertArrayEquals(expected, resultArray);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(1, 2, 6, 3, 4, 5, 6), 6, new int[] {1, 2, 3, 4, 5}),
                Arguments.of(createList(), 1, null),
                Arguments.of(createList(7, 7, 7, 7), 7, null)
        );
    }

}
