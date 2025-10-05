package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindLargestValueInEachTreeRowTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestValues(TreeNode treeNode, List<Integer> expected) {
        var solution = new FindLargestValueInEachTreeRow();
        assertEquals(expected, solution.largestValues(treeNode));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,3,2,5,3,null,9}), List.of(1, 3, 9)),
                Arguments.of(buildTree(new Integer[]{1,2,3}), List.of(1, 3))
        );
    }

}
