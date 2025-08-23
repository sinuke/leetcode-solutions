package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.createList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertBinaryNumberInLinkedListToIntegerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getDecimalValue(ListNode head, int expected) {
        var solution = new ConvertBinaryNumberInLinkedListToInteger();
        assertEquals(expected, solution.getDecimalValue(head));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(1,0,1), 5),
                Arguments.of(createList(0), 0)
        );
    }

}
