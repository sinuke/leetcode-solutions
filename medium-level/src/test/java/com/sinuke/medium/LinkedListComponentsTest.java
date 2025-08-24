package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListComponentsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numComponents(ListNode head, int[] nums, int expected) {
        var solution = new LinkedListComponents();
        assertEquals(expected, solution.numComponents(head, nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(0,1,2,3), new int[] {0,1,3}, 2),
                Arguments.of(buildList(0,1,2,3,4), new int[] {0,3,1,4}, 2),
                Arguments.of(buildList(0,1,2,3,4), new int[] {0,1,2,3}, 1)
        );
    }

}