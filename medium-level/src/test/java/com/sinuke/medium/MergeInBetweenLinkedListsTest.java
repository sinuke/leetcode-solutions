package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeInBetweenLinkedListsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeInBetween(ListNode list1, int a, int b, ListNode list2, ListNode expected) {
        var solution = new MergeInBetweenLinkedLists();
        assertArrayEquals(toArray(expected), toArray(solution.mergeInBetween(list1, a, b, list2)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(10,1,13,6,9,5), 3, 4, buildList(1000000,1000001,1000002), buildList(10,1,13,1000000,1000001,1000002,5)),
                Arguments.of(buildList(0,1,2,3,4,5,6), 2, 5, buildList(1000000,1000001,1000002,1000003,1000004), buildList(0,1,1000000,1000001,1000002,1000003,1000004,6))
        );
    }

}
