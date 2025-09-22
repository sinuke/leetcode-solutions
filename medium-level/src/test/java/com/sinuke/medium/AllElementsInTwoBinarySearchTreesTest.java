package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AllElementsInTwoBinarySearchTreesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getAllElements(TreeNode root1, TreeNode root2, List<Integer> expected) {
        var solution = new AllElementsInTwoBinarySearchTrees();
        assertEquals(expected, solution.getAllElements(root1, root2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {2,1,4}), buildTree(new Integer[]{1,0,3}), List.of(0,1,1,2,3,4)),
                Arguments.of(buildTree(new Integer[] {1,null,8}), buildTree(new Integer[]{8,1}), List.of(1,1,8,8))
        );
    }

}
