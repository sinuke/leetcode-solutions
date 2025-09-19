package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DeleteLeavesWithGivenValueTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeLeafNodes(TreeNode root, int target, TreeNode expected) {
        var solution =  new DeleteLeavesWithGivenValue();
        assertArrayEquals(toArray(expected), toArray(solution.removeLeafNodes(root, target)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {1,2,3,2,null,2,4}), 2, buildTree(new Integer[] {1,null,3,null,4})),
                Arguments.of(buildTree(new Integer[] {1,3,3,3,2}), 3, buildTree(new Integer[] {1,3,null,null,2})),
                Arguments.of(buildTree(new Integer[] {1,2,null,2,null,2}), 2, buildTree(new Integer[] {1})),
                Arguments.of(buildTree(new Integer[] {1,1,1}), 1, buildTree(new Integer[] {})),
                Arguments.of(buildTree(new Integer[] {1}), 1, buildTree(new Integer[] {}))
        );
    }

}
