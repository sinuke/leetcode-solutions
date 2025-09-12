package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfNodesWithEvenValuedGrandparentTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumEvenGrandparent(TreeNode root, int expected) {
        var solution = new SumOfNodesWithEvenValuedGrandparent();
        assertEquals(expected, solution.sumEvenGrandparent(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {6,7,8,2,7,1,3,9,null,1,4,null,null,null,5}), 18),
                Arguments.of(buildTree(new Integer[] {1}), 0)
        );
    }

}
