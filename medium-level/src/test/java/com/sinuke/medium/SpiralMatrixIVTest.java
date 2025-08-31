package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SpiralMatrixIVTest {

    @ParameterizedTest
    @MethodSource("testData")
    void spiralMatrix(int m, int n, ListNode head, int[][] expected) {
        var solution = new SpiralMatrixIV();
        assertArrayEquals(expected, solution.spiralMatrix(m, n, head));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, 5, buildList(3,0,2,6,8,1,7,9,4,2,5,5,0), new int[][] {{3,0,2,6,8},{5,0,-1,-1,1},{5,2,4,9,7}}),
                Arguments.of(1, 4, buildList(0,1,2), new int[][] {{0,1,2,-1}}),
                Arguments.of(10, 1, buildList(8,24,5,21,10,11,11,12,6,17), new int[][] {{8},{24},{5},{21},{10},{11},{11},{12},{6},{17}})
        );
    }

}
