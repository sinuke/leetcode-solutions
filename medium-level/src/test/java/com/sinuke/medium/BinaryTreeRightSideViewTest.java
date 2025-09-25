package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeRightSideViewTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rightSideView(TreeNode root, List<Integer> expected) {
        var solution = new BinaryTreeRightSideView();
        assertEquals(expected, solution.rightSideView(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,2,3,null,5,null,4}), List.of(1,3,4)),
                Arguments.of(buildTree(new Integer[]{1,2,3,4,null,null,null,5}), List.of(1,3,4,5)),
                Arguments.of(buildTree(new Integer[]{1,null,3}), List.of(1,3)),
                Arguments.of(buildTree(new Integer[]{}), List.of())
        );
    }

}
